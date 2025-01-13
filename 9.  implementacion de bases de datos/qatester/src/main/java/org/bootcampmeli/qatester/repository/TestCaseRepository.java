package org.bootcampmeli.qatester.repository;

import org.bootcampmeli.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
