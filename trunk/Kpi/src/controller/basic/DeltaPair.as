package controller.basic
{
	import controller.data.MathUtil;

	public class DeltaPair
	{
		private var standard:ValuePair;
		private var maximum:ValuePair;
		private var minimum:ValuePair;
		private var delta:ValuePair;
		
		public function DeltaPair(r:XML)
		{
			standard=new ValuePair(r.standard[0]);
			maximum=new ValuePair(r.maximum[0]);
			minimum=new ValuePair(r.minimum[0]);
			delta=new ValuePair(r.delta[0]);
		}
		
		public function getResult(value:int):Number
		{
			if(value>maximum.value)
				value=maximum.value;
			if (value<minimum.value)
				value=minimum.value;
			return MathUtil.round((value-standard.value)*delta.value);
		}
	}
}