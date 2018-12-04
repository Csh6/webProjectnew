window.onload=function()
{
    document.getElementById("username");
    document.getElementById("password");
    document.getElementById("checkpassword");
    document.getElementById("telphone");
    document.getElementById("email");
    document.getElementById("postCard");

    var temp;
    //制定校验规则
    var validateName = /^[a-zA-Z0-9]\w{6,14}$/;
    //密码
    var validatePsw = /^[a-zA-Z0-9]{6,14}$/;
    //手机号
    var validateTel = /^[0-9]{11}$/;
    //判断邮箱
    var validateEmail = /^([\w\.\-]+@)([\w\.\-]+)\.([\w]{2,4})$/;
    //邮政编码
    var validatePostCard = /[1-9][0-9]{5}/;
    //判断
    username.onblur=function()
    {
        var result = this.value.match(validateName);
        if(result == null)
        {
            document.getElementById("userinfo").innerHTML="<span style='color:red'>用户名不合法</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("userinfo").innerHTML="<span style='color:greenyellow'>用户名申请成功</span>";
            return temp=true;
        }
    }
    //密码判断
    password.onblur=function()
    {
        var result = this.value.match(validatePsw);
        if(result == null)
        {
            document.getElementById("pswinfo").innerHTML="<span style='color:red'>密码不合法</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("pswinfo").innerHTML="<span style='color:greenyellow'>密码合法</span>";
            return temp=true;
        }
    }
    //密码值确定
    checkpassword.onblur=function()
    {
//		this.value.match(validatePsw);
        if(this.value == password.value && this.value!=null)
        {
            document.getElementById("pinfo").innerHTML="<span style='color:greenyellow'>密码输入正确</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("pinfo").innerHTML="<span style='color:red'>请重新输入</span>";
            return temp=true;
        }
    }
    telphone.onblur=function()
    {
        var result = this.value.match(validateTel);
        if(result == null)
        {
            document.getElementById("telinfo").innerHTML="<span style='color:red'>手机号不合法</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("telinfo").innerHTML="<span style='color:greenyellow'>正确的手机号</span>";
            return temp=true;
        }
    }
    email.onblur=function()
    {
        var result =this.value.match(validateEmail);
        if(result == null)
        {
            document.getElementById("einfo").innerHTML="<span style='color:red'>邮箱不合法</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("einfo").innerHTML="<span style='color:greenyellow'>申请成功</span>";
            return temp=true;
        }
    }
    postCard.onblur=function()
    {
        var result = this.value.match(validatePostCard)
        if(result == null)
        {
            document.getElementById("poinfo").innerHTML="<span style='color:red'>邮编不合法</span>";
            return temp=false;
        }
        else
        {
            document.getElementById("poinfo").innerHTML="<span style='color:greenyellow'>有效邮编</span>";
            return temp=true;
        }
    }
    var btn1 = document.getElementById("btn1");
    btn1.onsubmit=function()
    {
        if(temp==true && username.value !="" && password.value!="" && telphone.value!=""&&email.value!=""&&postCard.value!="")
        {
            alert("注册成功！");
            return temp=true;
        }
        else
        {
            return temp=false;
        }
    }

}
