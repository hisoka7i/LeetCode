import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {
    //creating a hashmap, to maintain users, for easy retrival
    Map<Integer,User> userMap = new HashMap<>();
    private static int time_stamp;
    private class Tweet{
        int id;
        int time;
        Tweet next;

        Tweet(int id){
            this.id = id;
            this.time = time_stamp++;
            this.next = null;
        }
    }
    private class User {
         int id;
         Set<Integer> followers;
         Tweet head;

         User(int id){
            this.id = id;
            this.followers = new HashSet<>();
            //user will follow himself
            this.followers.add(id);
            this.head = null;
         }

         void addFollower(int id){
            this.followers.add(id);
         }

         void unfollow(int id){
            this.followers.remove(id);
         }

         void postTweet(int id){
            Tweet new_tweet = new Tweet(id);
            new_tweet.next = head;
            head = new_tweet;
         }
    }
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            createAndAddUser(userId);
        }
        userMap.get(userId).postTweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //here we will get all the tweets by user and it's followers, 
        //and put them in a max heap, based on time
        List<Integer> result = new LinkedList<>();
        if(!userMap.containsKey(userId)){
            return result;
        }

        Set<Integer> followers = userMap.get(userId).followers;

        PriorityQueue<Tweet> max_heap = new PriorityQueue<>((a,b)->b.time - a.time);
        for(int user: followers){
            Tweet tweet_head = userMap.get(user).head;
            while(tweet_head!=null){
                max_heap.add(tweet_head);
            }
        }

        int n = 0;
        while(n<10 && !max_heap.isEmpty()){
            Tweet current_tweet = max_heap.poll();
            result.add(current_tweet.id);
            n++;
            if(current_tweet!=null){
                //This is the smartest part of this code, here we are adding only if there is
                //next nodes in the head. 
                //here we are moving the head of 
                max_heap.add(current_tweet.next);
            }
        }
        return result;
    }

    public void createAndAddUser(int id){
        User new_user = new User(id);
            userMap.put(id, new_user);
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followeeId)){
            createAndAddUser(followeeId); 
        }
        if(!userMap.containsKey(followerId)){
            createAndAddUser(followeeId);
        }
        userMap.get(followerId).addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followeeId) || !userMap.containsKey(followerId)){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}
