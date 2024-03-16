package com.example.realadmin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.realadmin.system.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
