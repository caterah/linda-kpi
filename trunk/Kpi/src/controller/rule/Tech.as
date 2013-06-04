package controller.rule
{
	import flash.utils.Dictionary;
	
	import controller.basic.MultiPair;
	import controller.basic.TechPair;
	import controller.basic.ValuePair;

	public class Tech
	{
		private var _map:Dictionary;
		
		public function Tech(r:XML)
		{
			_map=new Dictionary();
			var size:int=r.children().length();
			var xml:XML;
			for (var i:uint=0;i<size;i++)
			{
				xml=r.children()[i];
				_map[String(xml.localName()).toLowerCase()]=new TechPair(xml);
			}
		}
		
		public function getTech(r:XML):Number
		{
			var category:String=r.@name;
			if (category==""||category==null)
			{
				category="develop";
			}
			return TechPair(_map[category]).getMultiValues(r);
		}
	}
}