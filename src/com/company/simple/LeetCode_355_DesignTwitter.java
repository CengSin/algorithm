package com.company.simple;

import java.util.*;
import java.util.stream.Collectors;

class Blog {
    int id;
    int time; // 使用整型数字表示发送的时间
}

class User {
    int id;
    List<Integer> followers;
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
            List<Integer> followers = user.followers;
            if (followers.size() > 0) {
                for (Integer id : followers) {
                    if (users.containsKey(id)) {
                        User follower = users.get(id);
                        // 按照times排序 times降序，合并两个有序链表
                        int i = 0, j = 0, cnt = 0;
                        while (cnt < 10 && i < user.blogs.size() && j < follower.blogs.size()) {
                            if (user.blogs.get(i).time > follower.blogs.get(j).time) {
                                res.add(user.blogs.get(i));
                                i++;
                            } else {
                                res.add(follower.blogs.get(j));
                                j++;
                            }
                            cnt++;
                        }
                        while (cnt < 10 && j < follower.blogs.size()) {
                            res.add(follower.blogs.get(j));
                            j++;
                            cnt++;
                        }
                        while (cnt < 10 && i < user.blogs.size()) {
                            res.add(user.blogs.get(i));
                            i++;
                            cnt++;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 10 && i < user.blogs.size(); i++) {
                    res.add(user.blogs.get(i));
                }
            }
        }
        return res.stream().map(i -> i.id).distinct().collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        regiserUser(followerId);
        regiserUser(followeeId);
        users.get(followerId).followers.add(followeeId);
    }

    private void regiserUser(int followerId) {
        if (!users.containsKey(followerId)) {
            User user = new User();
            users.put(followerId, user);
            user.id = followerId;
            user.blogs = new LinkedList<>();
            user.followers = new LinkedList<>();
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        regiserUser(followerId);
        regiserUser(followeeId);
        List<Integer> followers = users.get(followerId).followers;
        if (followers.contains(followeeId)) {
            followers.removeIf(integer -> integer == followeeId);
        }
    }
}

public class LeetCode_355_DesignTwitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }

}
