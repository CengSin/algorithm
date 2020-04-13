package com.company.simple;

import java.util.*;
import java.util.stream.Collectors;

class Blog {
    int id;
    int time; // 使用整型数字表示发送的时间
}

class User {
    int id;
    Set<Integer> followers;
    List<Blog> blogs;
}

class Twitter {

    Map<Integer, User> users;

    int times; // 唯一标识所有用户发送博客的time

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        users = new HashMap<>();
        times = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        regiserUser(userId);
        User user = users.get(userId);
        Blog blog = new Blog();
        blog.id = tweetId;
        blog.time = times++;
        user.blogs.add(0, blog);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Blog> res = new LinkedList<>();

        if (users.containsKey(userId)) {
            User user = users.get(userId);
            int len = 10;
            for (int i = 0; i < len && i < user.blogs.size(); i++) {
                res.add(user.blogs.get(i));
            }
            Set<Integer> followers = user.followers;
            if (followers.size() > 0) {
                for (Integer id : followers) {
                    if (id != userId && users.containsKey(id)) {
                        User follower = users.get(id);
                        int i = 0, j = 0;
                        while (i < len && j < follower.blogs.size()) {
                            if (i < res.size() && res.get(i).time < follower.blogs.get(j).time) {
                                res.add(i, follower.blogs.get(j));
                                if (res.size() > len) {
                                    res.remove(res.size() - 1);
                                }
                                i++;
                                j++;
                            } else if (i < res.size() && res.get(i).time >= follower.blogs.get(j).time) {
                                i++;
                            } else {
                                res.add(i, follower.blogs.get(j));
                                i++;
                                j++;
                            }
                        }
                    }
                }
            }
        }
        return res.stream().map(i -> i.id).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        regiserUser(followerId);
        regiserUser(followeeId);
        users.get(followerId).followers.add(followeeId);
    }

    private void regiserUser(int userId) {
        if (!users.containsKey(userId)) {
            User user = new User();
            users.put(userId, user);
            user.id = userId;
            user.blogs = new LinkedList<>();
            user.followers = new HashSet<>();
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        regiserUser(followerId);
        regiserUser(followeeId);
        Set<Integer> followers = users.get(followerId).followers;
        if (followers.contains(followeeId)) {
            followers.removeIf(integer -> integer == followeeId);
        }
    }
}

public class LeetCode_355_DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        test1(twitter);
    }

    private static void test2(Twitter twitter) {
        // ["Twitter","postTweet","follow","follow","getNewsFeed","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
        // [[],[1,5],[1,2],[2,1],[2],[2,6],[1],[2],[2,1],[1],[2],[1,2],[1],[2]]
        twitter.postTweet(1, 5);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        System.out.println(twitter.getNewsFeed(2));
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(2, 1);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        System.out.println(twitter.getNewsFeed(2));
//        [null,null,null,null,[5],null,[6,5],[6,5],null,[6,5],[6],null,[5],[6]]
    }

    private static void test1(Twitter twitter) {
        //["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
        //[[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],[1],[1,2],[1]]
        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

}
