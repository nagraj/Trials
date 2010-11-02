package example;


class threadDemo implements Runnable {
        long minPrime;
       
		public threadDemo(long threadDemo) {
            this.minPrime = threadDemo;
        }

        public void run() {
            // compute primes larger than minPrime
        	
        	System.out.println("The prime is .." + minPrime);
        }
        
     
  	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		threadDemo td = new threadDemo(123);
		
		new Thread(td).start();
		
		Thread r =new Thread();
		
		System.out.println(r);
		
		
	

	}
	
}


