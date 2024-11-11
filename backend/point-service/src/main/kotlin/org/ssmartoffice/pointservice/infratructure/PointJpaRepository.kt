package org.ssmartoffice.pointservice.infratructure

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.time.LocalDateTime

@Repository
interface PointJpaRepository : JpaRepository<PointEntity, Long> {

    fun findByUserIdAndUseDateBetween(
        userId: Long,
        startDate: LocalDateTime,
        endDate: LocalDateTime,
        pageable: Pageable
    ): Page<PointEntity>

}