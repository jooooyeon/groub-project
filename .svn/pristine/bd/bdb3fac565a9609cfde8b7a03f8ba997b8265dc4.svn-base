$(document).ready(function() {
    // 시계 업데이트 함수
    function updateClock() {
        var now = new Date();
        var hours = now.getHours();
        var minutes = now.getMinutes();
        var seconds = now.getSeconds();

        // 2자리 숫자로 변환
        hours = ("0" + hours).slice(-2);
        minutes = ("0" + minutes).slice(-2);
        seconds = ("0" + seconds).slice(-2);

        // 시간 출력
        var timeString = hours + ":" + minutes + ":" + seconds;
        $('#clock').text(timeString);
    }

    // 1초마다 시계 업데이트
    setInterval(updateClock, 1000);
});
