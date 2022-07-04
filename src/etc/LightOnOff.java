package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Command {
    int O;
    int S;
    int T;

    public Command(int o, int s, int t) {
        this.O = o;
        this.S = s;
        this.T = t;
    }
}
public class LightOnOff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] lights = new boolean[N];
        Queue<Command> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            queue.add(new Command(O, S, T));
        }

        while (!queue.isEmpty()) {
            Command command = queue.poll();
            if (command.O == 0) {
                // 반전
                for (int j = command.S - 1; j < command.T; j++) {
                    lights[j] = !lights[j];
                }
            } else if (command.O == 1) {
                // 출력
                int cnt = 0;
                for (int j = command.S - 1; j < command.T; j++) {
                    if (lights[j]) {
                        cnt++;
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}
