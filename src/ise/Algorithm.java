package ise;

import java.util.HashMap;
import java.util.List;

public class Algorithm {
	private Network net;
	private List<Integer> worstCasesResponseTime;
	
	public Algorithm(){}
	
	public Algorithm(Network net){
		this.net = net;
	}
	
	public Network getNet() {
		return net;
	}

	public void setNet(Network net) {
		this.net = net;
	}

	public Node firstNodeVisitedByJonI(Path j, Path i) throws NodeDoesNotExistException {
		for(int index = 0 ; index< i.getNodes().size() ; index++){
			if( ! j.getNodes().contains(i.getNodes().get(index)) ){
				return i.getNodes().get(index);
			}
		}
		throw new NodeDoesNotExistException();
	}
	
	public Node lastNodeVisitedByJonI(Path j, Path i) throws NodeDoesNotExistException {
		for(int index = i.getNodes().size()-1 ; index >= 0 ; index--){
			if( ! j.getNodes().contains(i.getNodes().get(index)) ){
				return i.getNodes().get(index);
			}
		}
		throw new NodeDoesNotExistException();
	}
	
	public Node firstNodeVisitedByJonI(Flow j, Flow i) throws NodeDoesNotExistException {
		return this.firstNodeVisitedByJonI(j.getPath(), i.getPath());
	}
	
	public Node lastNodeVisitedByJonI(Flow j, Flow i) throws NodeDoesNotExistException {
		return this.lastNodeVisitedByJonI(j.getPath(), i.getPath());
	}
	
	public Node firstNodeVisitedByJonIRestrictedToH(Flow j, Flow i, Node h) throws NodeDoesNotExistException {
		List<Node> iSubNodesList = i.getPath().getNodes().subList(0, i.getPath().getNodes().indexOf(h));
		List<Node> jNodesList = j.getPath().getNodes();
				
		for(int index = 0 ; index< iSubNodesList.size() ; index++){
			if( ! jNodesList.contains(iSubNodesList.get(index)) ){
				return iSubNodesList.get(index);
			}
		}
		throw new NodeDoesNotExistException();
	}
	
	public Node lastNodeVisitedByJonIRestrictedToH(Flow j, Flow i, Node h) throws NodeDoesNotExistException {
		List<Node> iSubNodesList = i.getPath().getNodes().subList(0, i.getPath().getNodes().indexOf(h));
		List<Node> jNodesList = j.getPath().getNodes();
				
		for(int index = iSubNodesList.size()-1 ; index >=0 ; index--){
			if( ! jNodesList.contains(iSubNodesList.get(index)) ){
				return iSubNodesList.get(index);
			}
		}
		throw new NodeDoesNotExistException();
	}
	
	public int minTimeTakenFromSourceToH(Flow f, Node h) {
		int res = 0;
		
		res = net.getLmin() * (f.getPath().getNodes().size() - 1);
		
		for(int i=1; i < f.getPath().getNodes().size() 
				&& (f.getPath().getNodes().get(i+1) != h); i++ ){
			res += f.getPath().getNodes().get(i).getCapacity().get(f);
		}
		return res;
	}
	
	public int maxTimeTakenFromSourceToH(Flow f, Node h) {
		int res = 0;
		res = net.getLmax() * (f.getPath().getNodes().size() - 1);
		Node currNode;
		for(int i=1; i < f.getPath().getNodes().size() 
				&& (f.getPath().getNodes().get(i+1) != h); i++ ){
			currNode = f.getPath().getNodes().get(i);
			res += currNode.getCapacity().get(f);
		}
		return res;
	}
	
	Node slowestNodeVisitedByJonI(Flow i, Flow j) {
		return null;
	}
	
	Node slowestNodeVisitedByIonHisPathRestrictedToH(Flow I, Node H) {
		return null;
	}
	
	Node slowestNodeVisitedByJonIRestrictedToH(Flow J, Flow I, Node H) {
		return null;
	}
	
	int computeM(Flow i, Node h) {
		return 0;
	}
	
	Node preI(Node h) {
		Node node = new Node();
		for(int i = 0; i < net.getNodes().size(); i++) {
			if(h.equals(net.getNodes().get(i))) {
				node = net.getNodes().get(i - 1);
			}
		}
		return node;
	}
	
	int computeA(Flow i, Flow j) {
		int jitter = j.getJitter();
		Node first = firstNodeVisitedByJonI(i, j);
		int m = computeM(i, first);
		int smax = maxTimeTakenFromSourceToH(j, first);
		int result = smax - m + jitter;
		return result;
	}
	
	int computeARestrictedToH(Flow i, Flow j, Node H) {
		return 0;
	}
	
	int computeBetaSlow(Flow i) {
		return 0;
	}
	public long beta_i_slow(int []ti, int [] ci,long lcm){
		 long beta=cofficient(ti,ci, lcm);
		 if (beta<lcm)
			 return beta;
		 else
			 return 0;
		 
	 }
	 public long cofficient(int []ti, int [] ci, long lcm){
		long sum =0 ;
	    
	    System.out.println(lcm);
	    for  (int i =1; i< ti.length; i++){
	    	sum+=lcm*ci[i]/ti[i];
	    }
		return sum;
	 }
	 
	 public long lCMf4Ti(int []ti){
		 long lcm;
		 lcm = ti[0];
		 for  (int i =1; i< ti.length; i++){
			 lcm = lCM(lcm, ti[i]);
		 }
		 return lcm;
		 
	 }
	 
	 public long lCM(long n, long m){
		 long lcm = (n == m || n == 1) ? m :(m == 1 ? n : 0);
	      /* this section increases the value of mm until it is greater  
	      / than or equal to nn, then does it again when the lesser 
	      / becomes the greater--if they aren't equal. If either value is 1,
	      / no need to calculate*/
	      if (lcm == 0) {
	         long mm = m, nn = n;
	         while (mm != nn) {
	             while (mm < nn) { mm += m; }
	             while (nn < mm) { nn += n; }
	         } 
	         
	         lcm = mm;
	      }
	      return lcm;
	 }
	int computeDelta(Flow i, Node h) {
		return 0;
	}
	
	int computeW(Flow i, int t) {
		HashMap<Node, Integer> w = new HashMap<Node, Integer>();
		int w1 = 0;
		int w2 = 0;
		for(Node h : i.getPath().getNodes()) {
			w1 = subfunction_computeW_initialize_sequence(i, t, h);
			w2 = subfunction_computeW_nextof_sequence(i, t, h, w1, w);
			while(w1 != w2) {
				w1 = w2;
				w2 = subfunction_computeW_nextof_sequence(i, t, h, w1, w);
			}
			w.put(h, w1);
		}
		return w1;
	}
	
	int subfunction_computeW_initialize_sequence(Flow i, int t, Node h){
		int w0 = 0;
		for(Flow j : i.getHigherPriorityFlows()) {
			Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
			w0+=slow.getCapacity().get(j);
		}
		for(Flow j : i.getSamePriorityFlows()) {
			Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
			w0+=slow.getCapacity().get(j);
		}
		Node slow = slowestNodeVisitedByIonHisPathRestrictedToH(i, h);
		w0+=(1+(int)Math.floor(((double)(t+i.getJitter()))/(double)(i.getPeriod()))) * slow.getCapacity().get(i); 
		Path p = i.getPath().pathRestrictedToH(h);
		for(Node k : p.getNodes()) {
			if (k!=slow) {
				int max = 0;
				for(Flow j : i.getHigherPriorityFlows()) {
					if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
						int cap = k.getCapacity().get(j);
						if(cap>max) {
							max = cap;
						}
					}
				}
				for(Flow j : i.getSamePriorityFlows()) {
					if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
						int cap = k.getCapacity().get(j);
						if(cap>max) {
							max = cap;
						}
					}
				}
				int cap = k.getCapacity().get(i);
				if(cap>max) {
					max = cap;
				}
				w0+= max;
			}
		}
		w0-=h.getCapacity().get(i);
		w0+=computeDelta(i, h);
		w0+=(p.getNodes().size() - 1)*net.getLmax();
		return w0;
	}
	
	int subfunction_computeW_nextof_sequence(Flow i, int t, Node h, int w1, HashMap<Node, Integer> w){
		int w2 = 0;
		for(Flow j : i.getHigherPriorityFlows()) {
			Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
			/* Please note that this is lastijh and not last"jih" */
			Node lastijh = lastNodeVisitedByJonIRestrictedToH(i, j, h);
			int val = 0;
			if (lastijh == h) {
				val = 1 + (int) Math.floor((double)(w1-minTimeTakenFromSourceToH(j, h)+computeARestrictedToH(i, j, h))/(double)(j.getJitter()));
			} else {
				val = 1 + (int) Math.floor((double)(w.get(lastijh)-minTimeTakenFromSourceToH(j, lastijh)+computeARestrictedToH(i, j, h))/(double)(j.getJitter()));
			}
			if(val<0){
				val = 0;
			}
			w2 += val * slow.getCapacity().get(j);
		}
		for(Flow j : i.getSamePriorityFlows()) {
			Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
			Node firstjih = firstNodeVisitedByJonIRestrictedToH(j, i, h);
			int val = 1 + (int) Math.floor((double)(t+maxTimeTakenFromSourceToH(i, firstjih)-minTimeTakenFromSourceToH(j, firstjih)+computeARestrictedToH(i, j, h))/(double)(j.getJitter()));
			if(val<0){
				val = 0;
			}
			w2 += val * slow.getCapacity().get(j);
		}
		Node slow = slowestNodeVisitedByIonHisPathRestrictedToH(i, h);
		Node firsti = i.getPath().getNodes().get(0);
		int val = 1 + (int) Math.floor((double)(t+maxTimeTakenFromSourceToH(i, firsti)-minTimeTakenFromSourceToH(i, firsti)+computeARestrictedToH(i, i, h))/(double)(i.getJitter()));
		if(val<0){
			val = 0;
		}
		w2 += val * slow.getCapacity().get(i);
		Path p = i.getPath().pathRestrictedToH(h);
		for(Node k : p.getNodes()) {
			if(k != slow){
				int max = 0;
				for(Flow j : i.getHigherPriorityFlows()) {
					if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
						int cap = k.getCapacity().get(j);
						if(cap>max) {
							max = cap;
						}
					}
				}
				for(Flow j : i.getSamePriorityFlows()) {
					if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
						int cap = k.getCapacity().get(j);
						if(cap>max) {
							max = cap;
						}
					}
				}
				int cap = k.getCapacity().get(i);
				if(cap>max) {
					max = cap;
				}
				w2+= max;
			}
		}
		w2-=h.getCapacity().get(i);
		w2+=computeDelta(i, h);
		w2+=(p.getNodes().size() - 1)*net.getLmax();
		return w2;
	}
}
