package controller.data
{
	public class PartData
	{
		public var before:Number;
		public var after:Number;
		public var title:String;
		public function get differ():Number {
			return MathUtil.round(after-before);
		}
	}
}