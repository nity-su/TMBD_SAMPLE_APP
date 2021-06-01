package com.anlyn.data.Mapper

import com.anlyn.data.model.SeriesData
import com.anlyn.domain.Mapper
import com.anlyn.domain.entitiy.SeriesEntity

class SeriesDataEntityMapper : Mapper<SeriesData,SeriesEntity>() {
    override fun mapFrom(from: SeriesData): SeriesEntity {
        return SeriesEntity(from.name,from.url,from.rating)
    }
}