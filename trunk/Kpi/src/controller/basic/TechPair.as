package controller.basic
{
	import controller.data.MathUtil;

	public class TechPair extends MultiPair
	{
		public function TechPair(r:XML)
		{
			super(r);
		}
		
		override public function getMultiValues(r:XML):Number
		{
			var size:int=r.children().length();
			var calc:Number=0;
			var xml:XML;
			for(var i:uint=0;i<size;i++)
			{
				xml=r.children()[i];
				calc+=getValue(xml.@name);
			}
			calc+=getValue("basic");
			return MathUtil.round(calc);
		}
	}
}