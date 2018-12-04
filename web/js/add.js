var scate = document.getElementsByName("scate");
var arrcate=["书","杯","棉服","日用"];

function addToarr(arr,select) {
    if (arr.length>0)
    {
        for (var i=0,i<arr.length;i++)
        {
            var option = new Option(arr[i],i);
            select.appendChild(option);
        }
    }
}
addToarr(arrcate,scate);
