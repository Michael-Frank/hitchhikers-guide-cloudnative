package de.qaware.oss.cloud.nativ.wjax2016;

import org.springframework.social.twitter.api.*;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Stream;

/**
 * Created by m.frank on 14.03.2017.
 */
public class MockTwitter implements Twitter {
    @Override
    public BlockOperations blockOperations() {
        return null;
    }

    @Override
    public DirectMessageOperations directMessageOperations() {
        return null;
    }

    @Override
    public FriendOperations friendOperations() {
        return null;
    }

    @Override
    public GeoOperations geoOperations() {
        return null;
    }

    @Override
    public ListOperations listOperations() {
        return null;
    }

    @Override
    public SearchOperations searchOperations() {
        return new SearchOperations() {
            @Override
            public SearchResults search(String query) {
                return search(query, 100);
            }

            @Override
            public SearchResults search(String query, int pageSize) {
                return new SearchResults(mockTweets(1), new SearchMetadata(-1, -1));
            }

            private List<Tweet> mockTweets(int size) {
              return Stream.generate(this::randomTweet).limit(size).collect(Collectors.toList());
            }

            private Tweet randomTweet() {
                //todo: more randomness
                return new Tweet(1L, "No tweets sorry. Twitter Api not reachable", new Date(), "", "", -1L, -1L, "en", "");
            }

            @Override
            public SearchResults search(String query, int pageSize, long sinceId, long maxId) {
                return null;
            }

            @Override
            public SearchResults search(SearchParameters searchParameters) {
                return null;
            }

            @Override
            public List<SavedSearch> getSavedSearches() {
                return null;
            }

            @Override
            public SavedSearch getSavedSearch(long searchId) {
                return null;
            }

            @Override
            public SavedSearch createSavedSearch(String query) {
                return null;
            }

            @Override
            public void deleteSavedSearch(long searchId) {

            }

            @Override
            public Trends getLocalTrends(long whereOnEarthId) {
                return null;
            }

            @Override
            public Trends getLocalTrends(long whereOnEarthId, boolean excludeHashtags) {
                return null;
            }
        };
    }

    @Override
    public StreamingOperations streamingOperations() {
        return null;
    }

    @Override
    public TimelineOperations timelineOperations() {
        return null;
    }

    @Override
    public UserOperations userOperations() {
        return null;
    }

    @Override
    public RestOperations restOperations() {
        return null;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }
}
