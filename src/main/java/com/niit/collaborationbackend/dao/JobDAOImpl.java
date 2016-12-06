package com.niit.collaborationbackend.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Job;
import com.niit.collaborationbackend.model.JobApplication;

@SuppressWarnings("deprecation")
@EnableTransactionManagement
@Repository("jobDAO")

public class JobDAOImpl implements JobDAO {
	
	
		@Autowired
		private SessionFactory sessionFactory;
		public JobDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public boolean save(Job job){	
			
			try{
			  sessionFactory.getCurrentSession().save(job);
			}catch (HibernateException e ){
				e.printStackTrace();
				return false;
			}
			return true;
		}	
		
		@Transactional
		public boolean save(JobApplication jobApplication){	
			
			try{
			  sessionFactory.getCurrentSession().save(jobApplication);
			}catch (HibernateException e ){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		@Transactional
		public boolean postJob(Job job) {
			
			try {
				sessionFactory.getCurrentSession().save(job);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		@Transactional
		public boolean update(Job job) {
			try {
				sessionFactory.getCurrentSession().update(job);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		@SuppressWarnings("unchecked")
		@Transactional
		public List<Job> list(){
			
			String hql = "from Job";
		@SuppressWarnings("rawtypes")
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Job> listJob = query.list();
		if(listJob == null  || listJob.isEmpty())
		{
			 return null;
			 
		}
		return query.list();
		}

		
		@Transactional
		public List<Job> getAllVacantJobs() {
			String hql = "from Job where status = 'V' ";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
		
		@Transactional
		public boolean applyForJob(JobApplication jobApplication) {
			try {
				sessionFactory.getCurrentSession().save(jobApplication);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		@Transactional
		public boolean updateJobApplication(JobApplication jobApplication) {
			try {
				sessionFactory.getCurrentSession().update(jobApplication);
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Transactional
		public JobApplication get(String userID, int jobID) {
			String hql = "from JobApplication where userID = '" + userID + "'and jobID = '"+ jobID+ "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return (JobApplication) query.list();
		}

		@Transactional
		public JobApplication getMyAppliedJobs(String userID) {
			String hql = "from Job where id in (select id from JobApplication where userID = '" + userID + "')";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return (JobApplication) query.list();
		}
		
		@Transactional
		public List<Job> getAllJobs() {
			String hql = "from Job";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}

		@Transactional
		public Job getJobDetails(int jobID) {
			return (Job) sessionFactory.getCurrentSession().get(Job.class, jobID);
		}

		@Transactional
		public JobApplication getJobApplication(int jobID) {
			String hql= "from JobApplication where jobID = " + "'" + jobID + "'";
			
			@SuppressWarnings({ "rawtypes" })
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings({ "unchecked" })
			List<JobApplication> list=query.list();
			if(list==null || list.isEmpty())
			{
				
				return null;
			}
			else
			{
				return list.get(0);
			}
	
		}

}