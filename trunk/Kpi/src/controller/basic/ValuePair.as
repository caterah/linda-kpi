package controller.basic
{
	public class ValuePair
	{
		public var name:String;
		public var description:String;
		public var value:Number;
		
		public function ValuePair(xml:XML)
		{
			name=xml.localName();
			description=xml.@description;
			value=xml.@value;
		}
	}
}