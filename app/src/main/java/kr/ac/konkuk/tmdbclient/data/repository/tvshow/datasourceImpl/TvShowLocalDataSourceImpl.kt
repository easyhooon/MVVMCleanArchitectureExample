package kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasourceImpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.konkuk.tmdbclient.data.db.TvShowDao
import kr.ac.konkuk.tmdbclient.data.model.tvshow.TvShow
import kr.ac.konkuk.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}