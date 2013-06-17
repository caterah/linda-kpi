package controller.data
{
	public class JobData
	{
		public var name:String;
		
		private var _points:Array=[];
		private var _ids:Array=[];
		private var _names:Array=[];
		
		private var _max:Number=0;
		private var _min:Number=0;
		private var _months:Number;
		
		public function addPoint(id:String,name:String,months:Number,value:Number):void {
			_ids.push(id);
			_names.push(name);
			_points.push(value);
			_months=months;
			if (value > _max)
				_max=value;
			if (value < _min)
				_min=value;
		}
		
		public function get max():Number {
			return MathUtil.round(_max);
		}
		
		public function get min():Number {
			return MathUtil.round(_min);
		}
		
		public function get months():Number {
			return MathUtil.round(_months);
		}
		
		public function get average():Number {
			var total:Number=0;
			for(var i:uint=0;i<_points.length;i++) {
				total+=_points[i];
			}
			return MathUtil.round(total/_points.length);
		}
	}
}