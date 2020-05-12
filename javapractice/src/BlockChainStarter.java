import java.util.ArrayList;

public class BlockChainStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		//Transaction tr=new Transaction("staris","hama",30);
		//System.out.println(tr.getInfo());
		
		
		Block block=new Block(1,null,0,new ArrayList());
		block.mine();
		block.getinfo(); 
		Block block2=new Block(2,block.getBlockHash(),0,new ArrayList());
		block2.addTransaction(new Transaction("staris","hama",1.5));
		block2.addTransaction(new Transaction("시은","hama",0.7));
		
		block2.mine();
		block2.getinfo();
		Block block3=new Block(3,block2.getBlockHash(),0,new ArrayList());
		block3.addTransaction(new Transaction("가경","시은",8.2));
		block3.addTransaction(new Transaction("hama","staris",0.4));
		
		
		block3.mine();
		block3.getinfo();
		Block block4=new Block(4,block3.getBlockHash(),0,new ArrayList());
		block4.addTransaction(new Transaction("시은","staris",0.1));
		
		block4.mine();
		block4.getinfo();
		
	}

}
