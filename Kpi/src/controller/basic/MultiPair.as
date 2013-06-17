package controller.basic
{
	import flash.utils.Dictionary;
	
	import controller.data.MathUtil;

	public class MultiPair
	{
		private var _map:Dictionary;
		private var _def:String;
		
		public function MultiPair(r:XML,def:String="standard")
		{
			_map=new Dictionary();
			_def=def;
			var size:int=r.children().length();
			var xml:XML;
			for (var i:uint=0;i<size;i++)
			{
				xml=r.children()[i];
				_map[String(xml.localName()).toLowerCase()]=new ValuePair(xml);
			}
		}
		
		public function getValue(key:String):Number
		{
			if (_map.hasOwnProperty(key))
			{
				return ValuePair(_map[key]).value;
			}
			return MathUtil.round(ValuePair(_map[_def]).value);
		}
		
		public function getMultiValues(r:XML):Number
		{
			var size:int=r.children().length();
			var calc:Number=0;
			var xml:XML;
			for(var i:uint=0;i<size;i++)
			{
				xml=r.children()[i];
				calc+=getValue(xml.@name);
			}
			return MathUtil.round(calc);
		}
	}
}