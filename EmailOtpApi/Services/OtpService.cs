using System.Net;
using System.Net.Mail;

namespace EmailOtpApi.Services
{
    public class OtpService
    {
        private readonly Dictionary<string, string> _otpStore = new();
        public bool SendOtp(string recipientEmail)
        {
            try
            {

                var otp = new Random().Next(1000, 9999).ToString();


                _otpStore[recipientEmail] = otp;


                var senderEmail = " ";
                var senderPassword = " ";

                var smtpClient = new SmtpClient("smtp.gmail.com")
                {
                    Port = 587,
                    Credentials = new NetworkCredential(senderEmail, senderPassword),
                    EnableSsl = true,
                };

                var mailMessage = new MailMessage
                {
                    From = new MailAddress(senderEmail),
                    Subject = "Your OTP Code",
                    Body = $"Your OTP is: {otp}",
                    IsBodyHtml = true,
                };

                mailMessage.To.Add(recipientEmail);

                smtpClient.Send(mailMessage);

                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool VerifyOtp(string recipientEmail, string otp)
        {
            return _otpStore.TryGetValue(recipientEmail, out var storedOtp) && storedOtp == otp;
        }
    }
}
