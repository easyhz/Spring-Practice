package com.example.spring_practice.repository;

import com.example.spring_practice.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items, Long> {

    List<Items> findItemsByExcludeType(Integer excludeType);

    // exclude type = 2 name 볼때
    List<Items> findItemsByExcludeTypeAndRegId(Integer excludeType, String regId);

    // exclude type = 1 call 볼때
//    @Query("SELECT i.excludeCall FROM Items i WHERE i.excludeType = :excludeType and i.regId = :regId")
//    List<Items> findExcludeCallByExcludeTypeAndRegId(Integer excludeType, String regId);

//    List<Items> findItemsBy
}
