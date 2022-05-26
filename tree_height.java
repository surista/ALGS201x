import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeight {
        int n;
        int parent[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        private class Node {
            private int index;
            private ArrayList<Node> children;

            public Node(int index) {
                this.index = index;
                this.children = new ArrayList<>();
            }

        }

        int computeHeight() {
            Node[] nodes = new Node[n];
            Node root = null;
            int root_index = 0;

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < n; i++) {
                if (parent[i] == -1) {
                    root = nodes[i];
                    root_index = i;
                } else {
                    nodes[parent[i]].children.add(nodes[i]);
                }
            }
            int findHeight = treeHeight(root);
            return findHeight;
        }

        public int treeHeight(Node node) {
            int maxHeight = 0;
            int height;
            if(node == null) return 0;
            for(int i = 0; i < node.children.size(); i++) {
               height = treeHeight(node.children.get(i));
               if (height > maxHeight) maxHeight = height;
            }
            return maxHeight + 1;
        }


    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
