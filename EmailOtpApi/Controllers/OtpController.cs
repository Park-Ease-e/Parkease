using EmailOtpApi.Services;
using Microsoft.AspNetCore.Mvc;

namespace EmailOtpApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OtpController : ControllerBase
    {
        private readonly OtpService _otpService;

        public OtpController(OtpService otpService)
        {
            _otpService = otpService;
        }
        [HttpPost("send-otp")]
        public IActionResult SendOtp([FromBody] string email)
        {
            if (_otpService.SendOtp(email))
            {
                return Ok("OTP sent successfully.");
            }

            return StatusCode(500, "Failed to send OTP.");
        }
        [HttpPost("verify-otp")]
        public IActionResult VerifyOtp([FromBody] OtpVerificationRequest request)
        {
            if (_otpService.VerifyOtp(request.Email, request.Otp))
            {
                return Ok("OTP verified successfully.");
            }

            return BadRequest("Invalid OTP.");
        }
    }


    public class OtpVerificationRequest
    {
        public string Email { get; set; }
        public string Otp { get; set; }
    }
}
