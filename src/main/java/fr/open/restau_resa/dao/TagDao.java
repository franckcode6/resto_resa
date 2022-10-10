package fr.open.restau_resa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.open.restau_resa.business.Tag;

public interface TagDao extends JpaRepository<Tag, Long> {
}
