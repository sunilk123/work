using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(TrialMVC.Startup))]
namespace TrialMVC
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
