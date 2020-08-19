package AirPlane;

import java.util.*;

import AirPlane.BestPath;
import AirPlane.BestPath.Node;
public class Test
{
    public static void main(String []args)
    {
        Node[][] nodes = new Node[4][4];
        
        Random rand = new Random();
        
        for(int i = 0; i < 4; i ++)
        {
            for (int j = 0; j < 4; j++)
            {
            	nodes[i][j] =new Node(rand.nextInt(10) + 1, rand.nextInt(10) + 1);
            	//nodes[i][j] =new BestPath().new Node(4, 4);
            }
        }
        
//        Node[][]nodes= { 
//	{new BestPath().new Node(2,1),new BestPath().new Node(2,1),new BestPath().new Node(2,1)},
//	{new BestPath().new Node(2,2),new BestPath().new Node(2,2),new BestPath().new Node(2,1)},
//	{new BestPath().new Node(2,2),new BestPath().new Node(2,2),new BestPath().new Node(2,1)}
//};
        
        BestPath best_path = new BestPath(nodes, 10);

        System.out.println("cheapest price: " + best_path.getCheapestPrice());
        System.out.println("num of cheapest paths: " + best_path.getNumOfCheapestPaths());
        System.out.println("cheapest paths: " + best_path.getAllCheapestPaths());
        System.out.println("\nnum of optimal paths: " + best_path.getNumOfOptimalPaths());
        System.out.println("optimal paths: " + best_path.getAllOptimalPaths());
        System.out.println("num of turns: " + best_path.printNumOfTurns());

        System.out.println("\n\ncheapest price 2: " + best_path.getCheapestPrice2());
        System.out.println("num of cheapest paths 2: " + best_path.getNumOfCheapestPaths2());
        System.out.println("cheapest paths 2: " + best_path.getAllCheapestPaths2());
        System.out.println("\nnum of optimal paths 2: " + best_path.getNumOfOptimalPaths2());
        System.out.println("optimal paths 2: " + best_path.getAllOptimalPaths2());
        System.out.println("num of turns 2: " + best_path.getNumOfTurns2());

    }

    
}