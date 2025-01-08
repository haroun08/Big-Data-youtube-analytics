CREATE KEYSPACE IF NOT EXISTS youtube_keyspace
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE youtube_keyspace;

CREATE TABLE IF NOT EXISTS video_statistics (
                                                id UUID PRIMARY KEY,
                                                index_value DOUBLE,
                                                totalviews_channelelapsedtime DOUBLE,
                                                channel_id TEXT,
                                                video_category_id INT,
                                                channel_view_count INT,
                                                likes_subscriber DOUBLE,
                                                views_subscribers DOUBLE,
                                                video_count INT,
                                                subscriber_count INT,
                                                video_id TEXT,
                                                dislikes_views DOUBLE,
                                                channel_elapsed_time INT,
                                                comments_subscriber DOUBLE,
                                                likes_views DOUBLE,
                                                channel_comment_count INT,
                                                video_view_count INT,
                                                likes_dislikes DOUBLE,
                                                comments_views DOUBLE,
                                                totvideos_videocount DOUBLE,
                                                elapsed_time DOUBLE,
                                                video_like_count INT,
                                                video_dislike_count INT,
                                                dislikes_subscriber DOUBLE,
                                                totviews_totsubs DOUBLE,
                                                views_elapsed_time DOUBLE,
                                                video_published TIMESTAMP,
                                                video_comment_count INT
);
