package com.androiddevs.runningappyt.repository

import com.androiddevs.runningappyt.db.Run
import com.androiddevs.runningappyt.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
){
    suspend fun insertRun(run:Run)=runDao.insertRun(run)
    suspend fun deleteRun(run:Run)=runDao.deleteRun(run)

    fun getAllRunsSortedByDate()=runDao.getAllRunsSortedBytimestamp()

    fun getAllRunsSortedByDistance()=runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTimeInMillis()=runDao.getAllRunsSortedBytimemillis()

    fun getAllRunsSortedByAvgSpeed()=runDao.getAllRunsSortedByavgSpeedInKMH()

    fun getAllRunsSortedByCaloriesBurned()=runDao.getAllRunsSortedByCaloriesBurbed()

    fun getTotalAvgSpeed()=runDao.getTotalAvgSpeed()

    fun getTotalCaloriesBurned()=runDao.getTotalCaloriesBurned()

    fun getTotalTimeInMillis()=runDao.getTotalTimeInMillis()

    fun getTotalDistance()=runDao.getTotalDistance()
}