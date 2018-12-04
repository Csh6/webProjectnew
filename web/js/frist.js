$(function () {
    $(".title").each(function () {
        // var state = $(this).next('ul');
        var state = $(this).next().css("display");
        $(this).click(function () {
            $(this).next().toggle(1000);
        });
    });
});