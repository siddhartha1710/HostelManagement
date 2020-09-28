/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.exceptions.NonexistentEntityException;
import database.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Siddhartha
 */
public class ComplaintsJpaController implements Serializable {

    public ComplaintsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Complaints complaints) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(complaints);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComplaints(complaints.getId()) != null) {
                throw new PreexistingEntityException("Complaints " + complaints + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Complaints complaints) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            complaints = em.merge(complaints);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = complaints.getId();
                if (findComplaints(id) == null) {
                    throw new NonexistentEntityException("The complaints with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Complaints complaints;
            try {
                complaints = em.getReference(Complaints.class, id);
                complaints.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The complaints with id " + id + " no longer exists.", enfe);
            }
            em.remove(complaints);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Complaints> findComplaintsEntities() {
        return findComplaintsEntities(true, -1, -1);
    }

    public List<Complaints> findComplaintsEntities(int maxResults, int firstResult) {
        return findComplaintsEntities(false, maxResults, firstResult);
    }

    private List<Complaints> findComplaintsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Complaints.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Complaints findComplaints(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Complaints.class, id);
        } finally {
            em.close();
        }
    }

    public int getComplaintsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Complaints> rt = cq.from(Complaints.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
