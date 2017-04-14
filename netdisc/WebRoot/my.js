function run()
		{	
			var password=document.form1.password.value;
			var repeatpassword=document.form1.repeatpassword.value;
			if(password!=repeatpassword)
			{
				document.getElementById("f3").innerHTML = "两次输入密码不一致"; 
				
			}
			else if(repeatpassword=="")
				{
				document.getElementById("f3").innerHTML = "请再次输入密码"; 
				}
			else{
				run2(); 
			}
			
		}
		function run2()
		{
			document.getElementById("f3").innerHTML = ""; 
		}
				
			function run3()
			{
				var password=document.form1.password.value;
				var repeatpassword=document.form1.repeatpassword.value;
				if(password!=repeatpassword||repeatpassword=="")
					{
						
						return false;
					}
						
				
			}
//			function run5()
//			{
//				//var username=document.form1.username.value;
//				var username=document.getElementsByName("username")[0].value;
//				
//				if(username=="")
//				{
//					document.getElementById("f1").innerHTML = "用户名不能为空"; 
//				}
//				else
//				{
//					document.getElementById("f1").innerHTML = ""; 
//				}	
//			}
			function run4()
			{
				var password=document.form1.password.value;
				var repeatpassword=document.form1.repeatpassword.value;
				if(password=="")
					{
					document.getElementById("f2").innerHTML = "请输入密码"; 
					
					}
				else if(password!=repeatpassword)
				{
					document.getElementById("f3").innerHTML = "两次输入密码不一致"; 
					
				}
				else
					{
					document.getElementById("f2").innerHTML = ""; 
					run2(); 
					
					}
				
			}