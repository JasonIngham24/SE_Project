package src/enginemangementapi/EngineManagerAPI.java;

class EngineManagerTest implements EngineManagerAPI {

	@Override
	@Test
	public void setData(int n) {
		data = n;
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public int getData() {
		// TODO Auto-generated method stub
		if(data != null) {
			return null;
			//handles nullpointer exception
		}
		return 0;
	}

	@Override
	@Test
	public int sumOfNthEvenFibbonaciNums(int n) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
