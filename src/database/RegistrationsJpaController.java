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
public class RegistrationsJpaController implements Serializable {

    public RegistrationsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registrations registrations) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registrations);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistrations(registrations.getId()) != null) {
                throw new PreexistingEntityException("Registrations " + registrations + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registrations registrations) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registrations = em.merge(registrations);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = registrations.getId();
                if (findRegistrations(id) == null) {
                    throw new NonexistentEntityException("The registrations with id " + id + " no longer exists.");
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
            Registrations registrations;
            try {
                registrations = em.getReference(Registrations.class, id);
                registrations.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registrations with id " + id + " no longer exists.", enfe);
            }
            em.remove(registrations);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registrations> findRegistrationsEntities() {
        return findRegistrationsEntities(true, -1, -1);
    }

    public List<Registrations> findRegistrationsEntities(int maxResults, int firstResult) {
        return findRegistrationsEntities(false, maxResults, firstResult);
    }

    private List<Registrations> findRegistrationsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registrations.class));
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

    public Registrations findRegistrations(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registrations.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistrationsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registrations> rt = cq.from(Registrations.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
