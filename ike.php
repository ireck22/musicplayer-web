<?php
	class A {
		public static function call(){
			echo "class A"."<br>" ;
		}
		public static function test(){
			self::call ();
			static::call();
		}
	
	}
	class B extends A{
		public static function call(){
			echo "class B"."<br>" ;
		}
	}
	B :: test () ;
	
	//trait
	class Base{
		public function hello(){
			echo 'method hello from class Base'.'<br>';
		}		
	}

	trait Hello{
		public function hello(){
			
			echo 'method hello from Trait Hello!'.'<br>';
		}
		public function hi(){
			
			echo 'method hi from Trait Hello'.'<br>';
		}
		abstract public function getValue();
		static public function staticMethod(){
			echo 'static method staticMethod from Trait Hello'.'<br>';
		}
		public function staticValue(){
			
			static $value;
			$value++;
			echo "$value".'<br>';
		}
	}
	trait Hi{
		public function hello(){
			perent :: hello () ;
			echo 'method hi from Trait Hi'.'<br>';
		}
		public function hi(){
			echo 'method hi from Trait Hi'.'<br>';
		}
		
	}
	trait HelloHi{
		use Hello, Hi{
			Hello :: hello insteadof Hi;
			Hi::hi insteadof hello;
		}
	}
	
	class Mynew extends Base{
		use HelloHi;
		private $value= 'class Mynew'.'<br>';
		public function hi(){
			echo 'method hi from class Mynew'.'<br>';
			
		}
		public function getValue(){
			return $this->value;
		}
	}
	
	$obj= new Mynew();
	$obj->hello();
	//輸出: 'method hi from Trait Hello'
	//優先及順序:Trait中的方法又覆蓋了基類中的方法
	$obj->hi();
	//輸出:method hi from class Mynew'
	//優先及順序:當中類中的方法會覆蓋trait的方法
	Mynew::staticMethod();
	//輸出:'static method staticMethod from trait hello'
	//靜態方法:trait中可以定義靜態方法
	echo $obj->getValue();
	//輸出:class Mynew'
	//抽象成員:trait中可以使用抽象方法
	$objOther=new Mynew();
	$obj->staticValue();
	//輸出:1
	//靜態成員:trait中可以使用靜態成員
	$objOther->staticValue();
	//輸出:2
	

	
?>