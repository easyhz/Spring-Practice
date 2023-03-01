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


    /**
     * 조회 : regId 받기 -> excludeCall, exclude List 전부 반환
     * 추가 : regId, excludeType, exclude Name 모두 받기
     * 수정 : regId, excludeType ->
     * 삭제 : id 정보 받기 -> 삭제'
     *
     * api 를 최소한으로 주는게 좋은지, 따로 주는 게 좋은지..
     */
}
