package enginemangementapi;

class EngineManagerTest implements EngineManagerAPI {

	
	@Test @Override
	public void setData(int n) {
		int data = n;
		// TODO Auto-generated method stub
		
	}


	@Test 	@Override
	public int getData() {
		// TODO Auto-generated method stub
		if(data != null) {
			return null;
			//handles nullpointer exception
		}
		return 0;
	}


	@Test 	@Override
	public int sumOfNthEvenFibbonaciNums(int n) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
