package ise;

import org.apache.commons.math.util.MathUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.*;
import exception.*;

import xml.XmlParser;

public class Algorithm {
	private Network net;
	public List<Integer> worstCasesResponseTime;
	
	public Algorithm(){
		this.worstCasesResponseTime = new ArrayList<>();
	}
	
	public Algorithm(Network net){
		this.net = net;
		this.worstCasesResponseTime = new ArrayList<>();
	}
	
	public Network getNet() {
		return net;
	}

	public void setNet(Network net) {
		this.net = net;
	}

	public Node firstNodeVisitedByJonI(Path j, Path i) throws NodeDoesNotExistException {
		for(int index = 0 ; index< j.getNodes().size() ; index++){
			if( i.getNodes().contains(j.getNodes().get(index)) ){
				return j.getNodes().get(index);
			}
		}
		throw new NodeDoesNotExistException("Fonction firstNodeVisitedByJonI : "
				+ "la node référencée n'est pas contenue dans le path correspondant");
	}
	
	public Node lastNodeVisitedByJonI(Path j, Path i) throws NodeDoesNotExistException {
		for(int index = j.getNodes().size()-1 ; index >= 0 ; index--){
			if( i.getNodes().contains(j.getNodes().get(index)) ){
				return j.getNodes().get(index);
			}
		}
		throw new NodeDoesNotExistException("Fonction lastNodeVisitedByJonI : "
				+ "la node référencée n'est pas contenue dans le path correspondant");
	}
	
	public Node firstNodeVisitedByJonI(Flow j, Flow i) throws NodeDoesNotExistException {
		return this.firstNodeVisitedByJonI(j.getPath(), i.getPath());
	}
	
	public Node lastNodeVisitedByJonI(Flow j, Flow i) throws NodeDoesNotExistException {
		return this.lastNodeVisitedByJonI(j.getPath(), i.getPath());
	}
	
	/* On restreint le chemin du flot i */
	public Node firstNodeVisitedByJonIRestrictedToH(Flow j, Flow i, Node h) throws NodeDoesNotExistException {
		List<Node> iSubNodesList = i.getPath().pathRestrictedToH(h).getNodes();//i.getPath().getNodes().subList(0, i.getPath().getNodes().indexOf(h) + 1);
		List<Node> jNodesList = j.getPath().getNodes();
		
		for(int index = 0 ; index< jNodesList.size() ; index++){
			if( iSubNodesList.contains(jNodesList.get(index)) ){
				return jNodesList.get(index);
			}
		}
		throw new NodeDoesNotExistException("Fonction firstNodeVisitedByJonIRestrictedToH : "
				+ "la node référencée n'est pas contenue dans le path correspondant");
	}
	
	public Node lastNodeVisitedByJonIRestrictedToH(Flow j, Flow i, Node h) throws NodeDoesNotExistException {
		List<Node> iSubNodesList = i.getPath().pathRestrictedToH(h).getNodes();//i.getPath().getNodes().subList(0, i.getPath().getNodes().indexOf(h) + 1);
		List<Node> jNodesList = j.getPath().getNodes();	

		for(int index = jNodesList.size()-1 ; index >=0 ; index--){	
			if( iSubNodesList.contains(jNodesList.get(index)) ){
				return jNodesList.get(index);
			}
		}
		throw new NodeDoesNotExistException("Fonction lastNodeVisitedByJonIRestrictedToH : "
				+ "la node référencée n'est pas contenue dans le path correspondant");
	}
	
	public int minTimeTakenFromSourceToH(Flow f, Node h) {
		int res = 0;
		Path p = null;
		try {
			p = f.getPath().pathRestrictedToH(h);
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			System.err.println("minTimeTakenFromSourceToH");
			XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
					+ ", Fonction : minTimeTakenFromSourceToH, "
					+ ", Erreur : " + e.getClass().getName()
					+ ", Message : " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		res = net.getLmin() * (p.getNodes().size() - 1);
		
		for(int i=1; i < p.getNodes().size() - 1; i++ ) {			
			res += p.getNodes().get(i).getCapacity().get(f);
		}
		return res;
	}
	
	public int maxTimeTakenFromSourceToH(Flow f, Node h) {
		int res = 0;
		Path p = null;
		try {
			p = f.getPath().pathRestrictedToH(h);
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			System.err.println("maxTimeTakenFromSourceToH");
			XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
					+ ", Fonction : maxTimeTakenFromSourceToH, "
					+ ", Erreur : " + e.getClass().getName()
					+ ", Message : " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
		res = net.getLmax() * (p.getNodes().size() - 1);
		
		for(int i=1; i < p.getNodes().size() - 1; i++ ) {			
			res += p.getNodes().get(i).getCapacity().get(f);
		}
		return res;
	}
	
	/*  Dans le papier : slowest node visited by flow i on path j
	 *  la capacité comparé est celle de j
	 *  S'il existe plusieurs nodes avec la plus faible capacité
	 *  on choisit la dernière sur le chemin */
	Node slowestNodeVisitedByJonI(Flow i, Flow j) throws NodeDoesNotExistException {
		Node res = null;
		List<Node> nodesI = i.getPath().getNodes();
		List<Node> nodesJ = j.getPath().getNodes();
		
		for(int index = 0 ; index< nodesJ.size() ; index++){
			if( nodesI.contains(nodesJ.get(index)) ){
				if(res == null){
					res = nodesJ.get(index);
				}else{
					if(nodesJ.get(index).getCapacity().get(j) > res.getCapacity().get(j)){
						res = nodesJ.get(index);
					}
				}
			}
		}
		if(res == null) {
			throw new NodeDoesNotExistException("Fonction slowestNodeVisitedByJonI : "
					+ "la node référencée n'est pas contenue dans le path correspondant");
		}
		return res;
	}
	
	Node slowestNodeVisitedByIonHisPathRestrictedToH(Flow i, Node h) throws NodeDoesNotExistException {
		Path p = i.getPath().pathRestrictedToH(h);
		Node res = p.getNodes().get(0);
		for(Node node : p.getNodes()){
			if(node.getCapacity().get(i) > res.getCapacity().get(i)){
				res = node;
			}
		}
		return res;
	}
	
	/**/
	Node slowestNodeVisitedByJonIRestrictedToH(Flow j, Flow i, Node h) throws NodeDoesNotExistException {
		Node res = null;
		List<Node> iSubNodesList = i.getPath().pathRestrictedToH(h).getNodes();//i.getPath().getNodes().subList(0, i.getPath().getNodes().indexOf(h));
		//List<Node> nodesI = i.getPath().getNodes();
		List<Node> nodesJ = j.getPath().getNodes();
		
		for(int index = 0 ; index< iSubNodesList.size() ; index++){
			if( nodesJ.contains(iSubNodesList.get(index)) ){
				if(res == null){
					res = iSubNodesList.get(index);
				}else{
					if(iSubNodesList.get(index).getCapacity().get(j) > res.getCapacity().get(j)){
						res = iSubNodesList.get(index);
					}
				}
			}
		}
		if(res == null) {
			throw new NodeDoesNotExistException("Fonction slowestNodeVisitedByJonIRestrictedToH : "
					+ "la node référencée n'est pas contenue dans le path correspondant");
		}
		return res;
	}
	
	int computeM(Flow i, Node h) {
		int m = 0;
		Node last = null;
		try {
			last = nodePreceedingHinFlowI(i, h);
		} catch (NodeDoesNotHavePredecessor e) {
			return 0;
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			return 0;
		}
		for (Node hprime : i.getPath().getNodes()) {
			if(hprime == last) {
				break;
			}
			int min = hprime.getCapacity().get(i);
			for(Flow j : i.getHigherPriorityFlows()) {
				try {
					if(firstNodeVisitedByJonI(j, i) == firstNodeVisitedByJonI(i, j)) {
						min = Math.min(min, hprime.getCapacity().get(j));
					}
				} catch (NodeDoesNotExistException e) {
					// TODO: handle exception
				}
			}
			for(Flow j : i.getSamePriorityFlows()) {
				try {
					if(firstNodeVisitedByJonI(j, i) == firstNodeVisitedByJonI(i, j)) {
						min = Math.min(min, hprime.getCapacity().get(j));
					}
				} catch (NodeDoesNotExistException e) {
					// TODO: handle exception
				}
			}
			m+= min + net.getLmin();
		}
		return m;
	}
	
	Node nodePreceedingHinFlowI(Flow i, Node h) throws NodeDoesNotHavePredecessor, NodeDoesNotExistException {
		for(int n = 0 ; n < i.getPath().getNodes().size(); n++) {
			if(h == i.getPath().getNodes().get(n)) {
				if(n == 0) {
					throw new NodeDoesNotHavePredecessor("Fonction nodePreceedingHinFlowI : "
									+ "première node visitée dans le path, elle ne possède donc pas de prédécesseurs directs");
				}
				return i.getPath().getNodes().get(n - 1);
			}
		}
		throw new NodeDoesNotExistException("Fonction nodePreceedingHinFlowI : "
								+ "Le noeud courant n'appartient pas au path renseigné");
	}
	
	int computeA(Flow i, Flow j) {
		int jitter = j.getJitter();
		try {
			Node first = firstNodeVisitedByJonI(i, j);
			int m = computeM(i, first);
			int smax = maxTimeTakenFromSourceToH(j, first);
			int result = smax - m + jitter;
			return result;
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			System.err.println("computeA");
			XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
					+ ", Fonction : computeA, "
					+ ", Erreur : " + e.getClass().getName()
					+ ", Message : " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	int computeARestrictedToH(Flow i, Flow j, Node H) {
		int jitter = j.getJitter();
		try {
			Node first = firstNodeVisitedByJonIRestrictedToH(i, j, H);
			int m = computeM(i, first);
			int smax = maxTimeTakenFromSourceToH(j, first);
			int result = smax - m + jitter;
			return result;
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			System.err.println("computeA");
			XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
					+ ", Fonction : computeA, "
					+ ", Erreur : " + e.getClass().getName()
					+ ", Message : " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	int _computeBetaSlow(Flow my_flow) {
		XmlParser.logger.log(Level.SEVERE, "utilisation d'un bouchon pour computeBetaSlow");
		return 1;
	}
	
	int computeBetaSlow(Flow my_flow) {
		List<Flow> allS,  allE;
		int ti[] , ci[] ;
		int count = 0;
		int beta;
				
		allS  = new ArrayList<Flow>();
		allE  = new ArrayList<Flow>();
		
		// get all priority Superior or Equal
		allS = my_flow.getHigherPriorityFlows();
		allE = my_flow.getSamePriorityFlows();
		
		// create period table and computation table
		ti = new int[allS.size()+allE.size()+1];
		ci = new int[allS.size()+allE.size()+1];
		
		// add my_flow period and calculation into the table
		ti[0] = my_flow.getPeriod();
		// i don't know how i get it
		try {
				ci[0] = slowestNodeVisitedByJonI(my_flow, my_flow).getCapacity().get(my_flow);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				ci[0] = 0;
				System.err.println("computeBetaSlow");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : computeBetaSlow, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		count ++;
		
		for (Flow flow : allS){
			ti[count] = flow.getPeriod();
			
			try {
				ci[count] = slowestNodeVisitedByJonI(my_flow, flow).getCapacity().get(my_flow);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				ci[count] = 0;
				System.err.println("computeBetaSlow");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : computeBetaSlow, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
			count ++;
		}

		for (Flow flow : allE){
			ti[count] = flow.getPeriod();

			try {
				ci[count] = slowestNodeVisitedByJonI(my_flow, flow).getCapacity().get(my_flow);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				ci[count] = 0;
				System.err.println("computeBetaSlow");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : computeBetaSlow, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
			count ++;
		}
		int lcm = lCMf4Ti(ti);
		beta = (int)beta_i_slow(ti, ci, lcm);

		return beta;
	}

	public long beta_i_slow(int []ti, int [] ci,int lcm){
		 long beta=cofficient(ti,ci, lcm);
		 if (beta<lcm)
			 return beta;
		 else
			 return 0;
		 
	 }

	public long cofficient(int []ti, int [] ci, int lcm){
		int sum =0 ;
	    for  (int i =0; i< ti.length; i++){
	    	sum+=lcm*ci[i]/ti[i];
	    }

		return sum;
	 }
	 
	public int lCMf4Ti(int []ti){
		 int lcm;
		 lcm = ti[0];
		 for  (int i =1; i< ti.length-1; i++){
			 if (lcm != ti[i])
				 lcm = MathUtils.lcm(lcm, ti[i]);
		 }
		 return lcm;
		 
	 }
	 
	int computeDelta(Flow i, Node hrestriction) {
		Node firsti = i.getPath().getNodes().get(0);
		Path p = null;
		try {
			p = i.getPath().pathRestrictedToH(hrestriction);
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
			System.err.println("computeDelta");
			e.printStackTrace();
			return 0;
		}
		int delta = 0;
		int max = 0;
		for (Flow j : i.getLowerPriorityFlows()) {
			try {
				if (firstNodeVisitedByJonI(j, i) == firsti) {
					int cap = firsti.getCapacity().get(j);
					max = Math.max(max, cap);
				}
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("computeDelta");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : computeDelta, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
		if(max - 1 > 0){
			delta+=max-1;
		}
		for(Node h : p.getNodes()) {
			if (h != firsti) {
				max = 0;
				for (Flow j : i.getLowerPriorityFlows()) {
					try {
						if (firstNodeVisitedByJonI(j, i) == h) {
							int cap = h.getCapacity().get(j);
							max = Math.max(max, cap);
						}
					} catch (NodeDoesNotExistException e) {
						// TODO: handle exception
						System.err.println("computeDelta");
						XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
								+ ", Fonction : computeDelta, "
								+ ", Erreur : " + e.getClass().getName()
								+ ", Message : " + e.getMessage());
						e.printStackTrace();
					}
				}
				if(max - 1 > 0) {
					delta+=max-1;
				}
				max = 0;
				for (Flow j : i.getLowerPriorityFlows()) {
					try {
						if (firstNodeVisitedByJonI(j, i)!= h) { 
							if (firstNodeVisitedByJonI(j, i) != firstNodeVisitedByJonI(i, j)) {
								int cap = h.getCapacity().get(j);
								max = Math.max(max, cap);
							}
						}
					} catch (NodeDoesNotExistException e) {
						// TODO: handle exception
						System.err.println("computeDelta");
						XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
								+ ", Fonction : computeDelta, "
								+ ", Erreur : " + e.getClass().getName()
								+ ", Message : " + e.getMessage());
						e.printStackTrace();
					}
				}
				if(max - 1 > 0) {
					delta+=max-1;
				}
				max = 0;
				for (Flow j : i.getLowerPriorityFlows()) {
					try {
						if (firstNodeVisitedByJonI(j, i)!= h) { 
							if (firstNodeVisitedByJonI(j, i) == firstNodeVisitedByJonI(i, j)) {
								int cap = h.getCapacity().get(j);
								max = Math.max(max, cap);
							}
						}
					} catch (NodeDoesNotExistException e) {
						// TODO: handle exception
						System.err.println("computeDelta");
						XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
								+ ", Fonction : computeDelta, "
								+ ", Erreur : " + e.getClass().getName()
								+ ", Message : " + e.getMessage());
						e.printStackTrace();
					}
				}
				if (i.getLowerPriorityFlows().size() != 0) {

					int val;
					try {
						val = max - nodePreceedingHinFlowI(i, h).getCapacity().get(i) + net.getLmax() - net.getLmin();
						if( val > 0) {
							delta+=val;
						}
					} catch (NodeDoesNotHavePredecessor e) {
						// TODO Auto-generated catch block
						XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
								+ ", Fonction : computeDelta, "
								+ ", Erreur : " + e.getClass().getName()
								+ ", Message : " + e.getMessage());
						e.printStackTrace();
					} catch (NodeDoesNotExistException e) {
						// TODO Auto-generated catch block
						XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
								+ ", Fonction : computeDelta, "
								+ ", Erreur : " + e.getClass().getName()
								+ ", Message : " + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return delta;
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
			try {
			 Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
			 w0+=slow.getCapacity().get(j);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_initialize_sequence");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : subfunction_computeW_initialize_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
		for(Flow j : i.getSamePriorityFlows()) {
			try {
				Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
				w0+=slow.getCapacity().get(j);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_initialize_sequence");
				XmlParser.logger.log(Level.WARNING, "Fonction : subfunction_computeW_initialize_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
		Node slow = null;
		Path p = null;
		try {
			slow = slowestNodeVisitedByIonHisPathRestrictedToH(i, h);
			w0+=(1+(int)Math.floor(((double)(t+i.getJitter()))/(double)(i.getPeriod()))) * slow.getCapacity().get(i); 
			try {
				p = i.getPath().pathRestrictedToH(h);
				for(Node k : p.getNodes()) {
					if (k!=slow) {
						int max = 0;
						for(Flow j : i.getHigherPriorityFlows()) {
							try {
								if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
									int cap = k.getCapacity().get(j);
									if(cap>max) {
										max = cap;
									}
								}
							} catch (NodeDoesNotExistException e) {
								// TODO: handle exception
								System.err.println("subfunction_computeW_initialize_sequence");
								XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
										+ ", Fonction : subfunction_computeW_initialize_sequence, "
										+ ", Erreur : " + e.getClass().getName()
										+ ", Message : " + e.getMessage());
								e.printStackTrace();
							}
						}
						for(Flow j : i.getSamePriorityFlows()) {
							try {
								if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
									int cap = k.getCapacity().get(j);
									if(cap>max) {
										max = cap;
									}
								}
							} catch (NodeDoesNotExistException e) {
								// TODO: handle exception
								System.err.println("subfunction_computeW_initialize_sequence");
								XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
										+ ", Fonction : subfunction_computeW_initialize_sequence, "
										+ ", Erreur : " + e.getClass().getName()
										+ ", Message : " + e.getMessage());
								e.printStackTrace();					
							}
						}
						int cap = k.getCapacity().get(i);
						if(cap>max) {
							max = cap;
						}
						w0+= max;
					}
				}
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_initialize_sequence");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : subfunction_computeW_initialize_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
		}
		
		w0-=h.getCapacity().get(i);
		w0+=computeDelta(i, h);
		w0+=(p.getNodes().size() - 1)*net.getLmax();
		return w0;
	}
	
	int subfunction_computeW_nextof_sequence(Flow i, int t, Node h, int w1, HashMap<Node, Integer> w){
		int w2 = 0;
		for(Flow j : i.getHigherPriorityFlows()) {
			try {
				Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
				/* Please note that this is lastijh and not last"jih" */
				Node lastijh = lastNodeVisitedByJonIRestrictedToH(i, j, h);
				if(w.get(lastijh) == null) {
					XmlParser.logger.log(Level.SEVERE, "w.get(lastijh) wasn't computed");
				}
				int val = 0;
				if (lastijh == h || w.get(lastijh) == null) {
					val = 1 + (int) Math.floor((double)(w1-minTimeTakenFromSourceToH(j, h)+computeARestrictedToH(i, j, h))/(double)(j.getPeriod()));
				} else {
					val = 1 + (int) Math.floor((double)(w.get(lastijh)-minTimeTakenFromSourceToH(j, lastijh)+computeARestrictedToH(i, j, h))/(double)(j.getPeriod()));
				}
				if(val<0){
					val = 0;
				}
				w2 += val * slow.getCapacity().get(j);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_nextof_sequence");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : subfunction_computeW_nextof_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
		for(Flow j : i.getSamePriorityFlows()) {
			try {
				Node slow = slowestNodeVisitedByJonIRestrictedToH(j, i, h);
				Node firstjih = firstNodeVisitedByJonIRestrictedToH(j, i, h);
				int val = 1 + (int) Math.floor((double)(t+maxTimeTakenFromSourceToH(i, firstjih)-minTimeTakenFromSourceToH(j, firstjih)+computeARestrictedToH(i, j, h))/(double)(j.getPeriod()));
				if(val<0){
					val = 0;
				}
				w2 += val * slow.getCapacity().get(j);
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_nextof_sequence");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : subfunction_computeW_nextof_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		}
		Path p = null;
		Node slow = null;
		try {
			slow = slowestNodeVisitedByIonHisPathRestrictedToH(i, h);
			Node firsti = i.getPath().getNodes().get(0);
			int val = 1 + (int) Math.floor((double)(t+maxTimeTakenFromSourceToH(i, firsti)-minTimeTakenFromSourceToH(i, firsti)+computeARestrictedToH(i, i, h))/(double)(i.getPeriod()));
			if(val<0){
				val = 0;
			}
			w2 += val * slow.getCapacity().get(i);
			try { 
				p = i.getPath().pathRestrictedToH(h);

				for(Node k : p.getNodes()) {
					if(k != slow){
						int max = 0;
						for(Flow j : i.getHigherPriorityFlows()) {
							try {
								if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
									int cap = k.getCapacity().get(j);
									if(cap>max) {
										max = cap;
									}
								}
							} catch (NodeDoesNotExistException e) {
								// TODO: handle exception
								System.err.println("subfunction_computeW_nextof_sequence");
								XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
										+ ", Fonction : subfunction_computeW_nextof_sequence, "
										+ ", Erreur : " + e.getClass().getName()
										+ ", Message : " + e.getMessage());
								e.printStackTrace();
							}
						}
						for(Flow j : i.getSamePriorityFlows()) {
							try {
								if(firstNodeVisitedByJonIRestrictedToH(j, i, h) == firstNodeVisitedByJonIRestrictedToH(i, j, h)){
									int cap = k.getCapacity().get(j);
									if(cap>max) {
										max = cap;
									}
								}
							} catch (NodeDoesNotExistException e) {
								// TODO: handle exception
								System.err.println("subfunction_computeW_nextof_sequence");
								XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
										+ ", Fonction : subfunction_computeW_nextof_sequence, "
										+ ", Erreur : " + e.getClass().getName()
										+ ", Message : " + e.getMessage());
								e.printStackTrace();
							}
						}
						int cap = k.getCapacity().get(i);
						if(cap>max) {
							max = cap;
						}
						w2+= max;
					}
				}
			} catch (NodeDoesNotExistException e) {
				// TODO: handle exception
				System.err.println("subfunction_computeW_nextof_sequence");
				XmlParser.logger.log(Level.WARNING, "Classe : " + this.getClass().getName()
						+ ", Fonction : subfunction_computeW_nextof_sequence, "
						+ ", Erreur : " + e.getClass().getName()
						+ ", Message : " + e.getMessage());
				e.printStackTrace();
			}
		} catch (NodeDoesNotExistException e) {
			// TODO: handle exception
		}
		w2-=h.getCapacity().get(i);
		w2+=computeDelta(i, h);
		w2+=(p.getNodes().size() - 1)*net.getLmax();
		return w2;
	}

	public List<Integer>  computeWorstCaseEndToEndResponse() {
		List<Flow> flows = net.getFlows();
		int t;
		Integer max;
		for (Flow i : flows) {
			max = 0;
			for (t=-(i.getJitter()); t<-(i.getJitter())+computeBetaSlow(i); t++) {
				Path path = i.getPath();
				List<Node> nodes = path.getNodes();
				Node last_i = nodes.get(nodes.size()-1);
				Integer val_inter = computeW(i, t)+ last_i.getCapacity().get(i)-t;
				max = Math.max(max, val_inter);
			}
			worstCasesResponseTime.add(max);
		}
		
		return worstCasesResponseTime;
	}
}
