package com.Hiking.Trails.repository;

import com.Hiking.Trails.model.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository <Trail, Long> {
}
