import java.util.*;

public class LeaderBoardService {
    public static List<LeaderBoardEntry> getLeaderBoard(List<User> users, List<Login> logins) {
        List<LeaderBoardEntry> leaderBoardList = new ArrayList<>();

        // Step 1: Track unique login timestamps for each user
        Map<Integer, Set<Integer>> uniqueLoginMap = new HashMap<>();
        for (Login login : logins) {
            // Get the current set of timestamps for this user ID (or create a new set)
            Set<Integer> uniqueTs = uniqueLoginMap.getOrDefault(login.id, new HashSet<>());
            uniqueTs.add(login.timestamp);  // Add this timestamp (only adds if not already there)
            uniqueLoginMap.put(login.id, uniqueTs); // Put the set back into the map
        }

        // Step 2: Map userId → name for easy lookup
        Map<Integer, String> userMap = new HashMap<>();
        for (User user : users) {
            userMap.put(user.id, user.name);
        }

        // Step 3: For each user with login data, create a leaderboard entry
        for (int id : uniqueLoginMap.keySet()) {
            String name = userMap.get(id);  // Get the user's name
            int uniqueCount = uniqueLoginMap.get(id).size();  // Count of unique timestamps
            leaderBoardList.add(new LeaderBoardEntry(name, uniqueCount));
        }

        // Step 4: Sort the leaderboard in descending order of login counts
        Collections.sort(leaderBoardList);

        return leaderBoardList;
    }

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class Login {
        int id;
        int timestamp;

        Login(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    static class LeaderBoardEntry implements Comparable<LeaderBoardEntry> {
        String name;
        int uniqueLogin;

        LeaderBoardEntry(String name, int uniqueLogin) {
            this.name = name;
            this.uniqueLogin = uniqueLogin;
        }

        @Override
        public int compareTo(LeaderBoardEntry o2) {
            return o2.uniqueLogin - this.uniqueLogin;
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<User> users = Arrays.asList(
            new User(1, "Alice"),
            new User(2, "Bob"),
            new User(3, "Charlie")
        );

        List<Login> logins = Arrays.asList(
            new Login(1, 100),
            new Login(1, 200),
            new Login(2, 150),
            new Login(2, 150), // Duplicate timestamp
            new Login(3, 300)
        );

        List<LeaderBoardEntry> leaderboard = getLeaderBoard(users, logins);
        for (LeaderBoardEntry entry : leaderboard) {
            System.out.println(entry.name + ": " + entry.uniqueLogin + " unique logins");
        }
    }
}
