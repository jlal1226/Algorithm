package Programmers.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS_TravelRoute {
    public static void main(String[] args) {
        // {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
        // {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
        String[][] tickets= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }
    static ArrayList<String> result;
    public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        ArrayList<TicketNode> ticketList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            ticketList.add(new TicketNode(tickets[i][0], tickets[i][1], false));
        }
        ArrayList<TicketNode> route;
        for (TicketNode node : ticketList) {
            if (node.getOrigin().equals("ICN")) {
                route = new ArrayList<>();
                route.add(node);
                node.setVisited(true);
                dfs(0, ticketList, node, route);
                node.setVisited(false);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void dfs(int depth, ArrayList<TicketNode> ticketList, TicketNode startNode, ArrayList<TicketNode> route) {
        if (depth == ticketList.size() - 1) {
            if (result != null ) {
                getShortRoute(getRoute(route));
            } else {
                result = getRoute(route);
            }
            return;
        }
        for (TicketNode node : ticketList) {
            if (startNode.getDestination().equals(node.getOrigin()) && !node.isVisited()) {
                node.setVisited(true);
                route.add(node);
                dfs(depth + 1, ticketList, node, route);
                node.setVisited(false);
                route.remove(node);
            }
        }
    }

    public static ArrayList<String> getRoute(ArrayList<TicketNode> route) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < route.size(); i++) {
            result.add(route.get(i).getOrigin());
            if (i == route.size() - 1) {
                result.add(route.get(i).getDestination());
            }
        }
        return result;
    }

    public static void getShortRoute(ArrayList<String> route) {
        if (result != null) {
            for (int i = 1; i < route.size(); i++) {
                // 글자 비교
                String str1 = result.get(i);
                String str2 = route.get(i);
                int compare = str1.compareTo(str2);
                if (compare < 0) {
                    break;
                } else if (compare > 0) {
                    result = route;
                    break;
                }
            }
        }
    }
}

class TicketNode {
    private String origin;
    private String destination;
    private boolean visited;

    public TicketNode(String origin, String destination, boolean visited) {
        this.origin = origin;
        this.destination = destination;
        this.visited = visited;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
