package controller.rule
{
	public class RuleOpreation
	{
		public var resume:Resume;
		public var interview:Interview;
		public var location:Location;
		public var education:Education;
		public var special:Special;
		public var jobTitle:Job;
		public var tech:Tech;
		public var offer:Offer;
		public var exp:Exp;
		public var grade:Grade;
		public var category:Category;
		
		public function RuleOpreation()
		{
		}
		
		public function build(r:XML):void
		{
			resume=new Resume(r.resume[0]);
			interview=new Interview(r.interview[0]);
			location=new Location(r.location[0]);
			education=new Education(r.education[0]);
			special=new Special(r.special[0]);
			jobTitle=new Job(r.job[0]);
			tech=new Tech(r.tech[0]);
			offer=new Offer(r.offer[0]);
			exp=new Exp(r.exp[0]);
			grade=new Grade(r.grade[0]);
			category=new Category(r.category[0]);
		}
		
		public function calc():void {
			
		}
		
	}
}