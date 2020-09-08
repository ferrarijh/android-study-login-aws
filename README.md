# android-study-login-aws
Simple login app with network connection using AWS EC2 and RDS mysql. Apache server on EC2 with login.php and register.php is connected with RDS. Used Volley for http requests.

## demo
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/instance.png" width="500px" height="300px">
</div>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/php.png">
</div>
EC2(ubuntu), RDS instances are up and apache, php is both installed on ec2 ubuntu.
<br></br>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/1.png">
</div>
At first, user with id of "study100" is not registered so trying login with that id will be in vain.
<br></br>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/2.png">
</div>
<br></br>
Toast message shows up on login failure. So I tried to login with existing user id which is "study4"
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/3.png">
</div>
Login succeeded valid userID. Let's move on to regsiter with id "study100".
<br></br>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/empty-age.png">
</div>
This is RegisterActivity. On erroneous submissions like empty field or non-integer age field, Toast message will pop up.
With valid submissions you will go back to LoginActivity with welcoming Toast message.
<br></br>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/4.png">
</div>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/registered.png">
</div>
Registration with user id "study100" has successfully registered. As you can see db shows a new row with user id "study100" is added.
<br></br>
<div>
  <img src="https://github.com/ferrarijh/android-study-login-aws/blob/master/demo/5.png">
</div>
<br></br>
After registeration user with id study100" can login.
