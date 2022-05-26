# python3

import sys
import threading

sys.setrecursionlimit(10**7) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size

def compute_height(n, parents):
    # create array for nodes
    nodes = [[] for i in range(n)]
    root = None

    # get labels for each node. -1 is root
    for child_index in range(n):
        parent_index = parents[child_index]
        if parent_index == -1:
            root = child_index
        else:
            nodes[parent_index] += [child_index]
            print(nodes)

    queue, height = [], 0
    queue += [root]
    while True:
        node_count = len(queue)
        if node_count == 0:
            return height
        height += 1
        while node_count > 0:
            node = queue.pop(0)

            if nodes[node]:
                for x in nodes[node]:
                    queue.append(x)

            node_count -= 1
    return height

def main():
    n = int(input())
    parents = list(map(int, input().split()))
    print(compute_height(n, parents))


if __name__ == "__main__":
    main()

