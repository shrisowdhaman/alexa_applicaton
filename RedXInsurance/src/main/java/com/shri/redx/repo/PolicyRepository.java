package com.shri.redx.repo;

import com.shri.redx.model.*;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PolicyRepository extends JpaRepository<Policy, Long> {

	 Policy findByPolicynumber(String policyNumber);
	 
	 Policy findPolicyexpdtByPolicynumberAndDob(String policyNumber, Date dob);
}
