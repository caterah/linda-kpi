package controller
{
	import flash.filesystem.File;
	import flash.filesystem.FileMode;
	import flash.filesystem.FileStream;
	
	import controller.rule.RuleOpreation;

	public class Controller
	{
		private static const RULE_URL:String="D:\\rule.xml";
		private static const DATA_URL:String="D:\\recruitment.xml";
		
		private var _rule:XML;
		private var _data:XML;
		private var _result:XML;
		
		private var _opreation:RuleOpreation;
		
		public function Controller()
		{
			_opreation=new RuleOpreation();
		}
		
		public function get opreation():RuleOpreation
		{
			return _opreation;
		}

		public function get result():XML
		{
			return _result;
		}

		public function get data():XML
		{
			return _data;
		}

		public function get rule():XML
		{
			return _rule;
		}

		public function loadRule():void
		{
			var file:File = new File();
			file.nativePath=RULE_URL;
			var fileStream:FileStream = new FileStream();
			fileStream.open(file, FileMode.READ);
			XML.ignoreComments=false;
			_rule = XML(fileStream.readUTFBytes(fileStream.bytesAvailable));
			fileStream.close();
			
			_opreation.build(_rule);
		}
		
		public function saveRule():void
		{
			var file:File = new File();
			file.nativePath=RULE_URL;
			var fileStream:FileStream = new FileStream();
			fileStream.open(file, FileMode.WRITE);
			var outputString:String = '<?xml version="1.0" encoding="utf-8"?>';
			outputString += _rule.toXMLString();
			fileStream.writeUTFBytes(outputString);
			fileStream.close();
			
			_opreation.build(_rule);
		}
		
		public function loadData():void
		{
			var file:File = new File();
			file.nativePath=DATA_URL;
			var fileStream:FileStream = new FileStream();
			fileStream.open(file, FileMode.READ);
			XML.ignoreComments=false;
			_data = XML(fileStream.readUTFBytes(fileStream.bytesAvailable));
			fileStream.close();
		}
		
		public function saveData():void
		{
			var file:File = new File();
			file.nativePath=DATA_URL;
			var fileStream:FileStream = new FileStream();
			fileStream.open(file, FileMode.WRITE);
			var outputString:String = '<?xml version="1.0" encoding="utf-8"?>';
			outputString += _data.toXMLString();
			fileStream.writeUTFBytes(outputString);
			fileStream.close();
		}
	}
}