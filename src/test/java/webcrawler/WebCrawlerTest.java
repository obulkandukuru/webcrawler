package test.java.webcrawler;


import main.java.webcrawler.WebCrawler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class WebCrawlerTest {

	private WebCrawler crawler;
	String expectedReturnDepth1 = "Internal Links:\n" +
			"https://wiprodigital.com/what-we-do/\n" +
			"https://wiprodigital.com/?s=&post_type[]=cases\n" +
			"https://wiprodigital.com/?s=&post_type[]=news\n" +
			"https://wiprodigital.com/2021/01/11/gartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year/\n" +
			"https://wiprodigital.com/services/wipro-digital-rig-and-devsecops/\n" +
			"https://wiprodigital.com/get-in-touch/\n" +
			"https://wiprodigital.com/?s=&post_type[]=post\n" +
			"https://wiprodigital.com/?s=&post_type[]=events\n" +
			"https://wiprodigital.com/join-our-team/\n" +
			"https://wiprodigital.com/cases/boosting-revenue-through-enhanced-training-at-a-leading-technology-company/\n" +
			"https://wiprodigital.com/get-in-touch/#wddi-locations\n" +
			"https://wiprodigital.com/2020/12/16/podcast-small-steps-to-become-a-better-agile-leader/\n" +
			"https://wiprodigital.com/what-we-think/experience-design-marketing-activation-enablement/\n" +
			"https://wiprodigital.com/2020/12/14/invest-in-enterprise-agility-to-succeed-in-the-new-normal/\n" +
			"http://wiprodigital.com\n" +
			"https://wiprodigital.com/who-we-are/\n" +
			"https://wiprodigital.com/who-we-are/#wdteam-vid\n" +
			"https://wiprodigital.com/what-we-think/\n" +
			"https://wiprodigital.com/2021/01/18/fiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india/\n" +
			"https://wiprodigital.com/who-we-are/#wdteam_meetus\n" +
			"https://wiprodigital.com/join-our-team/#wdcareers_team\n" +
			"https://wiprodigital.com/cases/imbuing-the-sephora-retail-experience-with-discovery-and-experimentation/\n" +
			"https://wiprodigital.com/services/next-gen-application-management-services/\n" +
			"https://wiprodigital.com/what-we-do/#work-three-circles-row\n" +
			"https://wiprodigital.com\n" +
			"https://wiprodigital.com/join-our-team/#wdcareers_jobs\n" +
			"https://wiprodigital.com/services/cio-strategy-and-advisory-services/\n" +
			"https://wiprodigital.com/2020/10/20/enterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence/\n" +
			"https://wiprodigital.com/designit-approach/\n" +
			"https://wiprodigital.com/who-we-are/#wdteam_leaders\n" +
			"https://wiprodigital.com/join-our-team/#wdwork-vid\n" +
			"https://wiprodigital.com/get-in-touch/#wddi-contact\n" +
			"https://wiprodigital.com/news/everest-group-positions-wipro-as-a-leader-in-cloud-native-application-services/\n" +
			"https://wiprodigital.com/news/wipro-achieve-amazon-emr-migration-partner-status/\n" +
			"https://wiprodigital.com/what-we-do/#wdwork_cases\n" +
			"https://wiprodigital.com/what-we-do/#wdwork_partners\n" +
			"https://wiprodigital.com/privacy-policy/\n" +
			"Media/Static Links: \n" +
			"script: <https://s17776.pcdn.co/wp-includes/js/wp-embed.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/bootstrap.min.js>\n" +
			"img: <https://px.ads.linkedin.com/collect/?pid=696835&fmt=gif> 1x1 ()\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/mason.js>\n" +
			"script: <https://app-ab39.marketo.com/js/forms2/js/forms2.min.js>\n" +
			"img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (Digital Transformat)\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wiprodigital.js>\n" +
			"img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo-dk-2X.png> x (wipro digital)\n" +
			"img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (wipro digital)\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/inview.js>\n" +
			"iframe: <https://www.googletagmanager.com/ns.html?id=GTM-THG25LC>\n" +
			"script: <https://s17776.pcdn.co/wp-content/plugins/advanced-responsive-video-embedder/build/main.js>\n" +
			"script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery-migrate.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdhome.js>\n" +
			"script: <https://www.googletagmanager.com/gtag/js?id=AW-701955939>\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery.slicknav.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery-latest.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/modernizr.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-includes/js/dist/vendor/wp-polyfill.min.js>\n" +
			"script: <https://s17776.pcdn.co/wp-content/plugins/wp-scroll-depth/js/jquery-scrolldepth/jquery.scrolldepth.min.js>\n" +
			"OutSide Links:\n" +
			"https://twitter.com/wiprodigital\n" +
			"https://www.linkedin.com/company/wipro-digital\n" +
			"https://www.facebook.com/WiproDigital/\n" +
			"https://digistories.wiprodigital.com/?utm_source=Subscribe_Link&utm_medium=WD_Internal_clicks&utm_campaign=Digi%20Stories_%20Subscription_Internal_Clicks&utm_content=7010K000001eahI";

	@BeforeEach
	void setUp() throws Exception {
		crawler = new WebCrawler();
	}

	@Test
	void testWebCrawlerNullorEmptySiteReturnsNull() {
		try {
			assertEquals(null, crawler.crawl(null));
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testWebCrawlerOpenWebSite() {
		String crawlMap = null;
		try {
			assertNotNull(crawler.crawl("http://wiprodigital.com"));
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testWebCrawlerBadSiteThrowsURISyntaxException() {
		assertThrows(URISyntaxException.class, () ->{
					crawler.crawl("http://www. thest.com");
				});
	}
	
	@Test
	void testWebCrawlerBadSiteThrowsMalformedURLException() {
		assertThrows(MalformedURLException.class, () ->{
					crawler.crawl("thest.com");
				});
	}
	
	@Test
	void testWebCrawlerCrawlWiprodigitalReturnsString() {

		try {
			String returnString = crawler.crawl("http://wiprodigital.com");
			assertEquals(expectedReturnDepth1, returnString);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testWebCrawlerCrawlWiprodigitalDepth1_ReturnsString() {
		try {
			String returnString = crawler.crawl("http://wiprodigital.com", 1);
			assertEquals(expectedReturnDepth1, returnString);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testWebCrawlerCrawlWiprodigitalDepth2_ReturnsString() {

		String actualString = "Internal Links:\n" +
                "https://wiprodigital.com/tag/enterprise-agility/\n" +
                "https://wiprodigital.com/2020/09/10/devsecops-demystified-securing-the-dev-and-ops-worlds/\n" +
                "https://wiprodigital.com/news/wipro-selected-as-strategic-partner-by-metro-bank-to-drive-it-transformation/\n" +
                "https://wiprodigital.com/what-we-do/#masthead\n" +
                "https://wiprodigital.com/cases/digitized-onboarding-experience-for-a-leading-telecommunications-company/\n" +
                "https://wiprodigital.com/tag/data-driven-enterprise/\n" +
                "https://wiprodigital.com/get-in-touch/\n" +
                "https://wiprodigital.com/partners/sag/\n" +
                "https://wiprodigital.com/partners/biz2credit/\n" +
                "https://wiprodigital.com/what-we-think/\n" +
                "https://wiprodigital.com/join-our-team/#masthead\n" +
                "https://wiprodigital.com/\n" +
                "https://wiprodigital.com/join-our-team/#wdcareers_team\n" +
                "https://wiprodigital.com/services/next-gen-application-management-services/\n" +
                "https://wiprodigital.com/partners/lightwing/\n" +
                "https://wiprodigital.com/what-we-do/#work-three-circles-row\n" +
                "https://wiprodigital.com/join-our-team/#wdcareers_jobs\n" +
                "https://wiprodigital.com/partners/quali/\n" +
                "https://wiprodigital.com/cases/enabling-in-house-app-development-for-an-american-bank/\n" +
                "https://wiprodigital.com/partners/xebia-labs/\n" +
                "https://wiprodigital.com/get-in-touch\n" +
                "https://wiprodigital.com/2020/04/01/adopt-agile-anywhere-for-seamless-software-delivery/\n" +
                "https://wiprodigital.com/?s=&post_type[]=news\n" +
                "https://wiprodigital.com/2021/01/11/gartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year/\n" +
                "https://wiprodigital.com/partners/app-dynamics/\n" +
                "https://wiprodigital.com/tag/intelligent-enterprise/\n" +
                "https://wiprodigital.com/what-we-do\n" +
                "https://wiprodigital.com/join-our-team/\n" +
                "https://wiprodigital.com/cases/boosting-revenue-through-enhanced-training-at-a-leading-technology-company/\n" +
                "https://wiprodigital.com/get-in-touch/#wddi-locations\n" +
                "https://wiprodigital.com/what-we-think/experience-design-marketing-activation-enablement/\n" +
                "https://wiprodigital.com/cases/helping-a-pharmaceutical-leader-discover-its-mobile-swagger/\n" +
                "https://wiprodigital.com/tag/agile/\n" +
                "https://wiprodigital.com/partners/apporbit/\n" +
                "https://wiprodigital.com/partners/red-hat/\n" +
                "https://wiprodigital.com/partners/tricentis/\n" +
                "https://wiprodigital.com/services/wipro-digital-rig/\n" +
                "https://wiprodigital.com/2020/10/20/enterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence/\n" +
                "https://wiprodigital.com/get-in-touch/wipro-digital-dublin/\n" +
                "https://wiprodigital.com/who-we-are/#wdteam_leaders\n" +
                "https://wiprodigital.com/join-our-team/#wdwork-vid\n" +
                "https://wiprodigital.com/tag/artificial-intelligence/\n" +
                "https://wiprodigital.com/partners/snowflake/\n" +
                "https://wiprodigital.com/cases/boosting-partner-effectiveness-for-a-professional-services-leader/\n" +
                "https://wiprodigital.com/news/wipro-achieve-amazon-emr-migration-partner-status/\n" +
                "https://wiprodigital.com/tag/workplace/\n" +
                "https://wiprodigital.com/what-we-do/#wdwork_cases\n" +
                "https://wiprodigital.com/privacy-policy/\n" +
                "https://wiprodigital.com/partners/processmaker/\n" +
                "https://wiprodigital.com/partners/ifs/\n" +
                "https://wiprodigital.com/cases/delivering-an-exceptional-mortgage-customer-experience-for-allied-irish-bank/\n" +
                "https://wiprodigital.com/partners/aprimo/\n" +
                "https://wiprodigital.com/?s=&post_type[]=cases\n" +
                "https://wiprodigital.com/cases/accelerating-a-financial-leaders-time-to-market/\n" +
                "https://wiprodigital.com/partners/whatfix/\n" +
                "https://wiprodigital.com/partners/sealights/\n" +
                "https://wiprodigital.com/partners/episerver/\n" +
                "https://wiprodigital.com/partners/sap-hybris/\n" +
                "https://wiprodigital.com/partners/ca-broadcom/\n" +
                "https://wiprodigital.com/cases/empowering-a1-telekom-to-reinvent-itself-with-digital-transformation/\n" +
                "https://wiprodigital.com/?s=&post_type[]=post\n" +
                "https://wiprodigital.com/?s=&post_type[]=events\n" +
                "https://wiprodigital.com/2020/12/14/invest-in-enterprise-agility-to-succeed-in-the-new-normal/\n" +
                "https://wiprodigital.com/partners/appian/\n" +
                "http://wiprodigital.com\n" +
                "https://wiprodigital.com/who-we-are/\n" +
                "https://wiprodigital.com/who-we-are/#wdteam-vid\n" +
                "https://wiprodigital.com/partners/leanix/\n" +
                "https://wiprodigital.com/who-we-are/#wdteam_meetus\n" +
                "https://wiprodigital.com/partners/headspin/\n" +
                "https://wiprodigital.com/partners/liferay/\n" +
                "https://wiprodigital.com/partners/datastax/\n" +
                "https://wiprodigital.com/what-we-think\n" +
                "https://wiprodigital.com/partners/cast/\n" +
                "https://wiprodigital.com\n" +
                "https://wiprodigital.com/services/cio-strategy-and-advisory-services/\n" +
                "https://wiprodigital.com/tag/enterprise-transformation/\n" +
                "https://wiprodigital.com/partners/vfunction/\n" +
                "https://wiprodigital.com/get-in-touch/#wddi-contact\n" +
                "https://wiprodigital.com/partners/tibco/\n" +
                "https://wiprodigital.com/news/everest-group-positions-wipro-as-a-leader-in-cloud-native-application-services/\n" +
                "https://wiprodigital.com/tag/analytics/\n" +
                "https://wiprodigital.com/partners/micro-focus/\n" +
                "https://wiprodigital.com/partners/pega/\n" +
                "https://wiprodigital.com/tag/digital-strategy/\n" +
                "https://wiprodigital.com/partners/adobe/\n" +
                "https://wiprodigital.com/what-we-do/\n" +
                "https://wiprodigital.com/partners/cisco/\n" +
                "https://wiprodigital.com/partners/yugabyte/\n" +
                "https://wiprodigital.com/cases/boosting-marketing-productivity-for-a-leading-american-bank/\n" +
                "https://wiprodigital.com/services/wipro-digital-rig-and-devsecops/\n" +
                "https://wiprodigital.com/partners/google/\n" +
                "https://wiprodigital.com/2020/12/16/podcast-small-steps-to-become-a-better-agile-leader/\n" +
                "https://wiprodigital.com/what-we-do/the-future-of-meaningful-cx-insights-from-our-experts/\n" +
                "https://wiprodigital.com/2020/11/10/how-composable-business-processes-enable-rapid-business-transformation/\n" +
                "https://wiprodigital.com/2021/01/18/fiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india/\n" +
                "https://wiprodigital.com/partners/vmware-tanzu/\n" +
                "https://wiprodigital.com/cases/transforming-the-security-suite-of-a-global-networking-leader/\n" +
                "https://wiprodigital.com/cases/digital-engagement-for-an-oil-and-gas-giant/\n" +
                "https://wiprodigital.com/partners/sprinklr/\n" +
                "https://wiprodigital.com/cases/imbuing-the-sephora-retail-experience-with-discovery-and-experimentation/\n" +
                "https://wiprodigital.com/partners/maxicaster/\n" +
                "https://wiprodigital.com/designit-approach/\n" +
                "https://wiprodigital.com/partners/aws/\n" +
                "https://wiprodigital.com/who-we-are/#masthead\n" +
                "https://wiprodigital.com/join-our-team\n" +
                "https://wiprodigital.com/cases/enabling-remote-device-management-for-the-biotech-leader/\n" +
                "https://wiprodigital.com/cases/in24-insure/\n" +
                "https://wiprodigital.com/partners/microsoft/\n" +
                "https://wiprodigital.com/what-we-do/#wdwork_partners\n" +
                "https://wiprodigital.com/tag/leadership/\n" +
                "Media/Static Links: \n" +
                "img: <https://px.ads.linkedin.com/collect/?pid=696835&fmt=gif> 1x1 ()\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/designit_logo.png> x (Get In Touch – Wipr)\n" +
                "script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery-migrate.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/isotope.pkgd.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdblog.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/dicontact.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (Digital Transformat)\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/service-min.js?v=4>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/03/Mukund-Kalmanker.jpeg> x (Mukund Kalmanker)\n" +
                "iframe: <https://player.vimeo.com/video/130310711?title=0&byline=0&portrait=0>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wiprodigital.js>\n" +
                "iframe: <https://player.vimeo.com/video/173961044?title=0&byline=0&portrait=0>\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo-dk-2X.png> x (wipro digital)\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdpost.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/10/Enterprise-IQ-02-1024x517.png> 1024x517 ()\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery-latest.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-includes/js/dist/vendor/wp-polyfill.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/plugins/ajax-load-more/core/dist/js/ajax-load-more.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery-1.12.0.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wow.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/bootstrap.min.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2017/09/Authors-Rajan-Kohli.jpg> x (Rajan Kohli)\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2016/08/Wipro-Digital-Cookies-05-28-18.png> 1241x2962 ()\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/mason.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdcareers-new.js>\n" +
                "iframe: <https://player.vimeo.com/video/279286339?title=0&byline=0&portrait=0>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-marketing-activation-1140x300-1.png> x ()\n" +
                "iframe: <https://www.googletagmanager.com/ns.html?id=GTM-THG25LC>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdhome.js>\n" +
                "script: <https://www.googletagmanager.com/gtag/js?id=AW-701955939>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdwork.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Rational-Wipro-Logo-Stacked-W.svg> x ()\n" +
                "script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery.min.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Ritu-Become-Agile-Leader-Podcast.jpg> 500x125 ()\n" +
                "iframe: <https://player.vimeo.com/video/279286694?title=0&byline=0&portrait=0>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/modernizr.min.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/designit_logo.png> x (Designit)\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-experience-design-1140x300-1.png> x ()\n" +
                "script: <https://s17776.pcdn.co/wp-includes/js/wp-embed.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdteam.js>\n" +
                "script: <https://app-ab39.marketo.com/js/forms2/js/forms2.min.js>\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/nice-select.min.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (Get In Touch – Wipr)\n" +
                "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (wipro digital)\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2018/05/Author-Rituparna-Ghosh.jpg> x (Rituparna Ghosh)\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/inview.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Marketing-Enablement-icon.svg> x ()\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Experience-Design-Icon.svg> x ()\n" +
                "script: <https://s17776.pcdn.co/wp-content/plugins/advanced-responsive-video-embedder/build/main.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Marketing-activation-icon.svg> x ()\n" +
                "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery.slicknav.min.js>\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/10/Enterprise-IQ-01-1024x732.png> 1024x732 ()\n" +
                "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-marketing-enablement-1140x300-1.png> x ()\n" +
                "script: <https://s17776.pcdn.co/wp-content/plugins/wp-scroll-depth/js/jquery-scrolldepth/jquery.scrolldepth.min.js>\n" +
                "OutSide Links:\n" +
                "https://hello.wiprodigital.com/gartnerats/gartner2020/?utm_source=wd_site&utm_medium=referral&utm_campaign=gartner_mqats_2020&utm_term=top&utm_content=7010K0000023sSt\n" +
                "https://twitter.com/andycoghlan\n" +
                "https://www.gartner.com/technology/media-products/newsletters/wipro/1-24L7VIDP/index.html\n" +
                "http://www.fcagroup.com/\n" +
                "https://www.linkedin.com/in/andycoghlan\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&title=Wipro becomes the first Global System Integrator to achieve Amazon EMR Migration partner status&summary=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&source=wiprodigital.com\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&hashtags=wiprodigital\n" +
                "https://twitter.com/anubhav_mishra\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&title=Imbuing the Sephora Retail Experience with Discovery and Experimentation&summary=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&source=wiprodigital.com\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&hashtags=wiprodigital\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&hashtags=wiprodigital\n" +
                "https://twitter.com/madhu7173\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&hashtags=wiprodigital\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fspark%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690271744%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=HFQgsaW5QTh11NqQgxOaZqttJzQBzHRu2DZsfJg2Usk%3D&reserved=0\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.wipro.com%2Fcloud%2Faws-business-group%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690321723%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=gBMxo4secjBzR1So3nUS6RkAc8lH4II8VJ%2Ffzo%2BOUEk%3D&reserved=0\n" +
                "https://developers.google.com/analytics/devguides/collection/analyticsjs/cookie-usage\n" +
                "https://twitter.com/wiprodigital\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&title=Fiat Chrysler Automobiles partners with Wipro to establish its first Global Digital Hub in India&summary=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&source=wiprodigital.com\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwiprodigital.com%2Fpartners%2Faws%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690311726%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=wigMWQbPfejyjLG3Vx6OPoSdim911SvtLunRZTkQoVc%3D&reserved=0\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&title=Invest in Enterprise Agility to Succeed in the New Normal&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&source=wiprodigital.com\n" +
                "https://www.linkedin.com/company/wipro-digital\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhive%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690281740%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=vTm7CHzGojyYDmKNR6bCEFhxFccutX4YDTZEQWlXReg%3D&reserved=0\n" +
                "https://twitter.com/WiproDigital\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&hashtags=wiprodigital\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&hashtags=wiprodigital\n" +
                "https://www.linkedin.com/in/kiran-minnasandram-8616a76\n" +
                "https://www.linkedin.com/in/rajramadas/\n" +
                "https://hello.wiprodigital.com/everest-cloudnative-report-sept-2020/\n" +
                "mailto:Shraboni.banerjee@wipro.com\n" +
                "https://www.linkedin.com/in/surbhat/\n" +
                "https://hello.wiprodigital.com/gartnerats/gartner2020/?utm_source=wd_site&utm_medium=referral&utm_campaign=gartner_mqats_2020&utm_term=bottom&utm_content=7010K0000023sSt\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&title=Boosting Revenue through Enhanced Training at a Leading Technology Company&summary=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&source=wiprodigital.com\n" +
                "https://marketing.adobe.com/resources/help/en_US/whitepapers/cookies/cookies_analytics.html\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhudi%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690301733%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=cGJI%2F%2Bfjar5zNQA6FgRs4rac9bLiJBOi8kysb7BO5NA%3D&reserved=0\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&title=Next-Gen Application Management Services&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&source=wiprodigital.com\n" +
                "mailto:dpo-europe@wipro.com\n" +
                "https://twitter.com/ritupg\n" +
                "https://twitter.com/kiran_minnas\n" +
                "https://www.linkedin.com/in/anubhavmishra/\n" +
                "https://twitter.com/RajRamadas\n" +
                "https://www.linkedin.com/in/jeremy-leach-6707963\n" +
                "https://www.wipro.com/newsroom/press-releases/2020/wipro-collaborates-with-aws-to-extend-devops-capabilities/\n" +
                "https://www.linkedin.com/in/rituparna-ghosh/\n" +
                "https://www.linkedin.com/in/alexbeal\n" +
                "https://twitter.com/mrjfleach\n" +
                "https://tools.google.com/dlpage/gaoptout\n" +
                "https://www.linkedin.com/in/kahly-berg-51b6b119/\n" +
                "https://www.aboutcookies.org/page/2/\n" +
                "https://www.linkedin.com/in/reynoldsalex\n" +
                "https://rationalcx.com/\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&hashtags=wiprodigital\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&title=Everest Group Positions Wipro as a Leader in Cloud-Native Application Services&summary=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&source=wiprodigital.com\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&title=Wipro DevOps&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&source=wiprodigital.com\n" +
                "mailto:global.consulting@wipro.com\n" +
                "https://www.linkedin.com/in/ravi-seshadhri-4977436/\n" +
                "https://www.linkedin.com/in/premchand-mohan-18389614/\n" +
                "http://www.wipro.com/\n" +
                "https://www.linkedin.com/in/ramachandran-padmanabhan-789173/\n" +
                "https://twitter.com/sudkes\n" +
                "https://legal.twitter.com/ads-terms/us.html#twitterconversiontrackingprogramt%26cs\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&title=Enterprise IQ: A New Framework to Evaluate Enterprise Intelligence&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&source=wiprodigital.com\n" +
                "mailto:info@wipro.com\n" +
                "https://twitter.com/SandhyaRArun\n" +
                "https://twitter.com/Surbhat\n" +
                "https://www.cloudbees.com/resources/devops-strategy-federated-devsecops\n" +
                "https://twitter.com/TheDavidKenner\n" +
                "https://twitter.com/gluecode\n" +
                "https://www.linkedin.com/in/manoj-madhusudhanan-b89a153\n" +
                "https://support.microsoft.com/en-in/help/17442/windows-internet-explorer-delete-manage-cookies\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&title=CIO Strategy and Advisory Services&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&source=wiprodigital.com\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&hashtags=wiprodigital\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&hashtags=wiprodigital\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.wipro.com%2Fcloud%2Fgetting-started-on-the-aws-emr-migration%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690331713%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=oHWuFJ4sUuFXNSUGOoZ1KjcurC2FZBbrhFBlMbpIlJ4%3D&reserved=0\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhbase%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690291739%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=Wg9QHyEMwz53%2BxKIROOgwftwcuIBdoq1ztFPSt9j3fM%3D&reserved=0\n" +
                "https://www.designit.com/work/discovery-and-experimentation-in-retail\n" +
                "https://www.linkedin.com/in/sudhirkesavan/\n" +
                "https://www.facebook.com/WiproDigital/\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&title=Podcast: Small Steps to Become a Better Agile Leader&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&source=wiprodigital.com\n" +
                "https://twitter.com/ramu_pad\n" +
                "https://www.linkedin.com/in/rajan-kohli-69365a\n" +
                "https://www.facebook.com/customaudiences/app/tos/?ref=u2u\n" +
                "https://www.linkedin.com/in/mukundkalmanker\n" +
                "https://business.twitter.com/en/help/ads-policies/other-policy-requirements/policies-for-conversion-tracking-and-tailored-audiences.html\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&hashtags=wiprodigital\n" +
                "https://twitter.com/SRINIHG\n" +
                "https://s17776.pcdn.co/wp-content/uploads/2016/08/Wipro-Digital-Cookies-05-28-18.png\n" +
                "https://twitter.com/rajan_kohli1\n" +
                "https://www.linkedin.com/in/srinivasaahg\n" +
                "https://www.linkedin.com/in/rahul-shah-218a782\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Fblogs%2Fbig-data%2Fuse-apache-flink-on-amazon-emr%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690291739%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=Xdc8b6eMyfvYAJPMSjrf5KITuH%2BiumZs50WumUy9zv0%3D&reserved=0\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&hashtags=wiprodigital\n" +
                "https://www.linkedin.com/legal/sas-terms#additional-terms-for-optional-conversion-tracking\n" +
                "https://www.linkedin.com/in/sandhyararun\n" +
                "https://digistories.wiprodigital.com/?utm_source=Subscribe_Link&utm_medium=WD_Internal_clicks&utm_campaign=Digi%20Stories_%20Subscription_Internal_Clicks&utm_content=7010K000001eahI\n" +
                "https://www.linkedin.com/in/davidkenner/\n" +
                "https://www.linkedin.com/in/mnmurthy\n" +
                "https://support.google.com/chrome/answer/95647?co=GENIE.Platform=Desktop&hl=en\n" +
                "https://twitter.com/rahulshahtweets\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fpresto%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690301733%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=oG30HMn1Ksliyit%2FEQSXC1uiPtw%2BL6rhqeqS8Gka1HA%3D&reserved=0\n" +
                "https://support.mozilla.org/en-US/kb/enable-and-disable-cookies-website-preferences\n" +
                "https://www.buzzsprout.com/636898/6552547\n" +
                "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&title=Gartner Names Wipro a Leader in Quality Engineering and Testing for Seventh Year&summary=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&source=wiprodigital.com\n" +
                "https://www.cloudbees.com/press/cloudbees-integrates-software-delivery-management-platform-google-cloud-build-and-tekton-break\n" +
                "https://designit.com\n" +
                "https://legal.twitter.com/ads-terms/us.html#twitteradsprogramt%26cs\n" +
                "https://www.linkedin.com/in/arun-melkote-88447a/?originalSubdomain=in\n" +
                "https://www.linkedin.com/in/karkera/\n" +
                "https://twitter.com/beal_a\n" +
                "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Femr-migration%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690321723%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=jw%2B7XvjjMSNK05H0zbdp6uLKw%2F8SnPD76TZwy58HUUE%3D&reserved=0\n" +
                "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&hashtags=wiprodigital\n" +
                "https://www.facebook.com/business/help/651294705016616?helpref=faq_content";
String s = "Internal Links:\n" +
        "https://wiprodigital.com/tag/enterprise-agility/\n" +
        "https://wiprodigital.com/2020/09/10/devsecops-demystified-securing-the-dev-and-ops-worlds/\n" +
        "https://wiprodigital.com/news/wipro-selected-as-strategic-partner-by-metro-bank-to-drive-it-transformation/\n" +
        "https://wiprodigital.com/what-we-do/#masthead\n" +
        "https://wiprodigital.com/cases/digitized-onboarding-experience-for-a-leading-telecommunications-company/\n" +
        "https://wiprodigital.com/tag/data-driven-enterprise/\n" +
        "https://wiprodigital.com/get-in-touch/\n" +
        "https://wiprodigital.com/partners/sag/\n" +
        "https://wiprodigital.com/partners/biz2credit/\n" +
        "https://wiprodigital.com/what-we-think/\n" +
        "https://wiprodigital.com/join-our-team/#masthead\n" +
        "https://wiprodigital.com/\n" +
        "https://wiprodigital.com/join-our-team/#wdcareers_team\n" +
        "https://wiprodigital.com/services/next-gen-application-management-services/\n" +
        "https://wiprodigital.com/partners/lightwing/\n" +
        "https://wiprodigital.com/what-we-do/#work-three-circles-row\n" +
        "https://wiprodigital.com/join-our-team/#wdcareers_jobs\n" +
        "https://wiprodigital.com/partners/quali/\n" +
        "https://wiprodigital.com/cases/enabling-in-house-app-development-for-an-american-bank/\n" +
        "https://wiprodigital.com/partners/xebia-labs/\n" +
        "https://wiprodigital.com/get-in-touch\n" +
        "https://wiprodigital.com/2020/04/01/adopt-agile-anywhere-for-seamless-software-delivery/\n" +
        "https://wiprodigital.com/?s=&post_type[]=news\n" +
        "https://wiprodigital.com/2021/01/11/gartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year/\n" +
        "https://wiprodigital.com/partners/app-dynamics/\n" +
        "https://wiprodigital.com/tag/intelligent-enterprise/\n" +
        "https://wiprodigital.com/what-we-do\n" +
        "https://wiprodigital.com/join-our-team/\n" +
        "https://wiprodigital.com/cases/boosting-revenue-through-enhanced-training-at-a-leading-technology-company/\n" +
        "https://wiprodigital.com/get-in-touch/#wddi-locations\n" +
        "https://wiprodigital.com/what-we-think/experience-design-marketing-activation-enablement/\n" +
        "https://wiprodigital.com/cases/helping-a-pharmaceutical-leader-discover-its-mobile-swagger/\n" +
        "https://wiprodigital.com/tag/agile/\n" +
        "https://wiprodigital.com/partners/apporbit/\n" +
        "https://wiprodigital.com/partners/red-hat/\n" +
        "https://wiprodigital.com/partners/tricentis/\n" +
        "https://wiprodigital.com/services/wipro-digital-rig/\n" +
        "https://wiprodigital.com/2020/10/20/enterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence/\n" +
        "https://wiprodigital.com/get-in-touch/wipro-digital-dublin/\n" +
        "https://wiprodigital.com/who-we-are/#wdteam_leaders\n" +
        "https://wiprodigital.com/join-our-team/#wdwork-vid\n" +
        "https://wiprodigital.com/tag/artificial-intelligence/\n" +
        "https://wiprodigital.com/partners/snowflake/\n" +
        "https://wiprodigital.com/cases/boosting-partner-effectiveness-for-a-professional-services-leader/\n" +
        "https://wiprodigital.com/news/wipro-achieve-amazon-emr-migration-partner-status/\n" +
        "https://wiprodigital.com/tag/workplace/\n" +
        "https://wiprodigital.com/what-we-do/#wdwork_cases\n" +
        "https://wiprodigital.com/privacy-policy/\n" +
        "https://wiprodigital.com/partners/processmaker/\n" +
        "https://wiprodigital.com/partners/ifs/\n" +
        "https://wiprodigital.com/cases/delivering-an-exceptional-mortgage-customer-experience-for-allied-irish-bank/\n" +
        "https://wiprodigital.com/partners/aprimo/\n" +
        "https://wiprodigital.com/?s=&post_type[]=cases\n" +
        "https://wiprodigital.com/cases/accelerating-a-financial-leaders-time-to-market/\n" +
        "https://wiprodigital.com/partners/whatfix/\n" +
        "https://wiprodigital.com/partners/sealights/\n" +
        "https://wiprodigital.com/partners/episerver/\n" +
        "https://wiprodigital.com/partners/sap-hybris/\n" +
        "https://wiprodigital.com/partners/ca-broadcom/\n" +
        "https://wiprodigital.com/cases/empowering-a1-telekom-to-reinvent-itself-with-digital-transformation/\n" +
        "https://wiprodigital.com/?s=&post_type[]=post\n" +
        "https://wiprodigital.com/?s=&post_type[]=events\n" +
        "https://wiprodigital.com/2020/12/14/invest-in-enterprise-agility-to-succeed-in-the-new-normal/\n" +
        "https://wiprodigital.com/partners/appian/\n" +
        "http://wiprodigital.com\n" +
        "https://wiprodigital.com/who-we-are/\n" +
        "https://wiprodigital.com/who-we-are/#wdteam-vid\n" +
        "https://wiprodigital.com/partners/leanix/\n" +
        "https://wiprodigital.com/who-we-are/#wdteam_meetus\n" +
        "https://wiprodigital.com/partners/headspin/\n" +
        "https://wiprodigital.com/partners/liferay/\n" +
        "https://wiprodigital.com/partners/datastax/\n" +
        "https://wiprodigital.com/what-we-think\n" +
        "https://wiprodigital.com/partners/cast/\n" +
        "https://wiprodigital.com\n" +
        "https://wiprodigital.com/services/cio-strategy-and-advisory-services/\n" +
        "https://wiprodigital.com/tag/enterprise-transformation/\n" +
        "https://wiprodigital.com/partners/vfunction/\n" +
        "https://wiprodigital.com/get-in-touch/#wddi-contact\n" +
        "https://wiprodigital.com/partners/tibco/\n" +
        "https://wiprodigital.com/news/everest-group-positions-wipro-as-a-leader-in-cloud-native-application-services/\n" +
        "https://wiprodigital.com/tag/analytics/\n" +
        "https://wiprodigital.com/partners/micro-focus/\n" +
        "https://wiprodigital.com/partners/pega/\n" +
        "https://wiprodigital.com/tag/digital-strategy/\n" +
        "https://wiprodigital.com/partners/adobe/\n" +
        "https://wiprodigital.com/what-we-do/\n" +
        "https://wiprodigital.com/partners/cisco/\n" +
        "https://wiprodigital.com/partners/yugabyte/\n" +
        "https://wiprodigital.com/cases/boosting-marketing-productivity-for-a-leading-american-bank/\n" +
        "https://wiprodigital.com/services/wipro-digital-rig-and-devsecops/\n" +
        "https://wiprodigital.com/partners/google/\n" +
        "https://wiprodigital.com/2020/12/16/podcast-small-steps-to-become-a-better-agile-leader/\n" +
        "https://wiprodigital.com/what-we-do/the-future-of-meaningful-cx-insights-from-our-experts/\n" +
        "https://wiprodigital.com/2020/11/10/how-composable-business-processes-enable-rapid-business-transformation/\n" +
        "https://wiprodigital.com/2021/01/18/fiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india/\n" +
        "https://wiprodigital.com/partners/vmware-tanzu/\n" +
        "https://wiprodigital.com/cases/transforming-the-security-suite-of-a-global-networking-leader/\n" +
        "https://wiprodigital.com/cases/digital-engagement-for-an-oil-and-gas-giant/\n" +
        "https://wiprodigital.com/partners/sprinklr/\n" +
        "https://wiprodigital.com/cases/imbuing-the-sephora-retail-experience-with-discovery-and-experimentation/\n" +
        "https://wiprodigital.com/partners/maxicaster/\n" +
        "https://wiprodigital.com/designit-approach/\n" +
        "https://wiprodigital.com/partners/aws/\n" +
        "https://wiprodigital.com/who-we-are/#masthead\n" +
        "https://wiprodigital.com/join-our-team\n" +
        "https://wiprodigital.com/cases/enabling-remote-device-management-for-the-biotech-leader/\n" +
        "https://wiprodigital.com/cases/in24-insure/\n" +
        "https://wiprodigital.com/partners/microsoft/\n" +
        "https://wiprodigital.com/what-we-do/#wdwork_partners\n" +
        "https://wiprodigital.com/tag/leadership/\n" +
        "Media/Static Links: \n" +
        "img: <https://px.ads.linkedin.com/collect/?pid=696835&fmt=gif> 1x1 ()\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/designit_logo.png> x (Get In Touch – Wipr)\n" +
        "script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery-migrate.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/isotope.pkgd.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdblog.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/dicontact.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (Digital Transformat)\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/service-min.js?v=4>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/03/Mukund-Kalmanker.jpeg> x (Mukund Kalmanker)\n" +
        "iframe: <https://player.vimeo.com/video/130310711?title=0&byline=0&portrait=0>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wiprodigital.js>\n" +
        "iframe: <https://player.vimeo.com/video/173961044?title=0&byline=0&portrait=0>\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo-dk-2X.png> x (wipro digital)\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdpost.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/10/Enterprise-IQ-02-1024x517.png> 1024x517 ()\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery-latest.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-includes/js/dist/vendor/wp-polyfill.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/plugins/ajax-load-more/core/dist/js/ajax-load-more.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery-1.12.0.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wow.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/bootstrap.min.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2017/09/Authors-Rajan-Kohli.jpg> x (Rajan Kohli)\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2016/08/Wipro-Digital-Cookies-05-28-18.png> 1241x2962 ()\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/mason.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdcareers-new.js>\n" +
        "iframe: <https://player.vimeo.com/video/279286339?title=0&byline=0&portrait=0>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-marketing-activation-1140x300-1.png> x ()\n" +
        "iframe: <https://www.googletagmanager.com/ns.html?id=GTM-THG25LC>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdhome.js>\n" +
        "script: <https://www.googletagmanager.com/gtag/js?id=AW-701955939>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdwork.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Rational-Wipro-Logo-Stacked-W.svg> x ()\n" +
        "script: <https://s17776.pcdn.co/wp-includes/js/jquery/jquery.min.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Ritu-Become-Agile-Leader-Podcast.jpg> 500x125 ()\n" +
        "iframe: <https://player.vimeo.com/video/279286694?title=0&byline=0&portrait=0>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/modernizr.min.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/designit_logo.png> x (Designit)\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-experience-design-1140x300-1.png> x ()\n" +
        "script: <https://s17776.pcdn.co/wp-includes/js/wp-embed.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/wdteam.js>\n" +
        "script: <https://app-ab39.marketo.com/js/forms2/js/forms2.min.js>\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/nice-select.min.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (Get In Touch – Wipr)\n" +
        "img: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/images/logo.png> x (wipro digital)\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2018/05/Author-Rituparna-Ghosh.jpg> x (Rituparna Ghosh)\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/inview.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Marketing-Enablement-icon.svg> x ()\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Experience-Design-Icon.svg> x ()\n" +
        "script: <https://s17776.pcdn.co/wp-content/plugins/advanced-responsive-video-embedder/build/main.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/Marketing-activation-icon.svg> x ()\n" +
        "script: <https://s17776.pcdn.co/wp-content/themes/wiprodigital/scripts/jquery.slicknav.min.js>\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/10/Enterprise-IQ-01-1024x732.png> 1024x732 ()\n" +
        "img: <https://s17776.pcdn.co/wp-content/uploads/2020/12/wipro-marketing-enablement-1140x300-1.png> x ()\n" +
        "script: <https://s17776.pcdn.co/wp-content/plugins/wp-scroll-depth/js/jquery-scrolldepth/jquery.scrolldepth.min.js>\n" +
        "OutSide Links:\n" +
        "https://hello.wiprodigital.com/gartnerats/gartner2020/?utm_source=wd_site&utm_medium=referral&utm_campaign=gartner_mqats_2020&utm_term=top&utm_content=7010K0000023sSt\n" +
        "https://twitter.com/andycoghlan\n" +
        "https://www.gartner.com/technology/media-products/newsletters/wipro/1-24L7VIDP/index.html\n" +
        "http://www.fcagroup.com/\n" +
        "https://www.linkedin.com/in/andycoghlan\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&title=Wipro becomes the first Global System Integrator to achieve Amazon EMR Migration partner status&summary=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&source=wiprodigital.com\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&hashtags=wiprodigital\n" +
        "https://twitter.com/anubhav_mishra\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&title=Imbuing the Sephora Retail Experience with Discovery and Experimentation&summary=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&source=wiprodigital.com\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&hashtags=wiprodigital\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fimbuing-the-sephora-retail-experience-with-discovery-and-experimentation%2F&hashtags=wiprodigital\n" +
        "https://twitter.com/madhu7173\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&hashtags=wiprodigital\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fspark%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690271744%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=HFQgsaW5QTh11NqQgxOaZqttJzQBzHRu2DZsfJg2Usk%3D&reserved=0\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.wipro.com%2Fcloud%2Faws-business-group%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690321723%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=gBMxo4secjBzR1So3nUS6RkAc8lH4II8VJ%2Ffzo%2BOUEk%3D&reserved=0\n" +
        "https://developers.google.com/analytics/devguides/collection/analyticsjs/cookie-usage\n" +
        "https://twitter.com/wiprodigital\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&title=Fiat Chrysler Automobiles partners with Wipro to establish its first Global Digital Hub in India&summary=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F18%2Ffiat-chrysler-automobiles-partners-with-wipro-to-establish-its-first-global-digital-hub-in-india%2F&source=wiprodigital.com\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwiprodigital.com%2Fpartners%2Faws%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690311726%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=wigMWQbPfejyjLG3Vx6OPoSdim911SvtLunRZTkQoVc%3D&reserved=0\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&title=Invest in Enterprise Agility to Succeed in the New Normal&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&source=wiprodigital.com\n" +
        "https://www.linkedin.com/company/wipro-digital\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhive%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690281740%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=vTm7CHzGojyYDmKNR6bCEFhxFccutX4YDTZEQWlXReg%3D&reserved=0\n" +
        "https://twitter.com/WiproDigital\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F14%2Finvest-in-enterprise-agility-to-succeed-in-the-new-normal%2F&hashtags=wiprodigital\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&hashtags=wiprodigital\n" +
        "https://www.linkedin.com/in/kiran-minnasandram-8616a76\n" +
        "https://www.linkedin.com/in/rajramadas/\n" +
        "https://hello.wiprodigital.com/everest-cloudnative-report-sept-2020/\n" +
        "mailto:Shraboni.banerjee@wipro.com\n" +
        "https://www.linkedin.com/in/surbhat/\n" +
        "https://hello.wiprodigital.com/gartnerats/gartner2020/?utm_source=wd_site&utm_medium=referral&utm_campaign=gartner_mqats_2020&utm_term=bottom&utm_content=7010K0000023sSt\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&title=Boosting Revenue through Enhanced Training at a Leading Technology Company&summary=https%3A%2F%2Fwiprodigital.com%2Fcases%2Fboosting-revenue-through-enhanced-training-at-a-leading-technology-company%2F&source=wiprodigital.com\n" +
        "https://marketing.adobe.com/resources/help/en_US/whitepapers/cookies/cookies_analytics.html\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhudi%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690301733%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=cGJI%2F%2Bfjar5zNQA6FgRs4rac9bLiJBOi8kysb7BO5NA%3D&reserved=0\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&title=Next-Gen Application Management Services&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&source=wiprodigital.com\n" +
        "mailto:dpo-europe@wipro.com\n" +
        "https://twitter.com/ritupg\n" +
        "https://twitter.com/kiran_minnas\n" +
        "https://www.linkedin.com/in/anubhavmishra/\n" +
        "https://twitter.com/RajRamadas\n" +
        "https://www.linkedin.com/in/jeremy-leach-6707963\n" +
        "https://www.wipro.com/newsroom/press-releases/2020/wipro-collaborates-with-aws-to-extend-devops-capabilities/\n" +
        "https://www.linkedin.com/in/rituparna-ghosh/\n" +
        "https://www.linkedin.com/in/alexbeal\n" +
        "https://twitter.com/mrjfleach\n" +
        "https://tools.google.com/dlpage/gaoptout\n" +
        "https://www.linkedin.com/in/kahly-berg-51b6b119/\n" +
        "https://www.aboutcookies.org/page/2/\n" +
        "https://www.linkedin.com/in/reynoldsalex\n" +
        "https://rationalcx.com/\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fnext-gen-application-management-services%2F&hashtags=wiprodigital\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&title=Everest Group Positions Wipro as a Leader in Cloud-Native Application Services&summary=https%3A%2F%2Fwiprodigital.com%2Fnews%2Feverest-group-positions-wipro-as-a-leader-in-cloud-native-application-services%2F&source=wiprodigital.com\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&title=Wipro DevOps&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&source=wiprodigital.com\n" +
        "mailto:global.consulting@wipro.com\n" +
        "https://www.linkedin.com/in/ravi-seshadhri-4977436/\n" +
        "https://www.linkedin.com/in/premchand-mohan-18389614/\n" +
        "http://www.wipro.com/\n" +
        "https://www.linkedin.com/in/ramachandran-padmanabhan-789173/\n" +
        "https://twitter.com/sudkes\n" +
        "https://legal.twitter.com/ads-terms/us.html#twitterconversiontrackingprogramt%26cs\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&title=Enterprise IQ: A New Framework to Evaluate Enterprise Intelligence&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F10%2F20%2Fenterprise-iq-a-new-framework-to-evaluate-enterprise-intelligence%2F&source=wiprodigital.com\n" +
        "mailto:info@wipro.com\n" +
        "https://twitter.com/SandhyaRArun\n" +
        "https://twitter.com/Surbhat\n" +
        "https://www.cloudbees.com/resources/devops-strategy-federated-devsecops\n" +
        "https://twitter.com/TheDavidKenner\n" +
        "https://twitter.com/gluecode\n" +
        "https://www.linkedin.com/in/manoj-madhusudhanan-b89a153\n" +
        "https://support.microsoft.com/en-in/help/17442/windows-internet-explorer-delete-manage-cookies\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&title=CIO Strategy and Advisory Services&summary=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&source=wiprodigital.com\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fnews%2Fwipro-achieve-amazon-emr-migration-partner-status%2F&hashtags=wiprodigital\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&hashtags=wiprodigital\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.wipro.com%2Fcloud%2Fgetting-started-on-the-aws-emr-migration%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690331713%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=oHWuFJ4sUuFXNSUGOoZ1KjcurC2FZBbrhFBlMbpIlJ4%3D&reserved=0\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fhbase%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690291739%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=Wg9QHyEMwz53%2BxKIROOgwftwcuIBdoq1ztFPSt9j3fM%3D&reserved=0\n" +
        "https://www.designit.com/work/discovery-and-experimentation-in-retail\n" +
        "https://www.linkedin.com/in/sudhirkesavan/\n" +
        "https://www.facebook.com/WiproDigital/\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&title=Podcast: Small Steps to Become a Better Agile Leader&summary=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&source=wiprodigital.com\n" +
        "https://twitter.com/ramu_pad\n" +
        "https://www.linkedin.com/in/rajan-kohli-69365a\n" +
        "https://www.facebook.com/customaudiences/app/tos/?ref=u2u\n" +
        "https://www.linkedin.com/in/mukundkalmanker\n" +
        "https://business.twitter.com/en/help/ads-policies/other-policy-requirements/policies-for-conversion-tracking-and-tailored-audiences.html\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fwipro-devops%2F&hashtags=wiprodigital\n" +
        "https://twitter.com/SRINIHG\n" +
        "https://s17776.pcdn.co/wp-content/uploads/2016/08/Wipro-Digital-Cookies-05-28-18.png\n" +
        "https://twitter.com/rajan_kohli1\n" +
        "https://www.linkedin.com/in/srinivasaahg\n" +
        "https://www.linkedin.com/in/rahul-shah-218a782\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Fblogs%2Fbig-data%2Fuse-apache-flink-on-amazon-emr%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690291739%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=Xdc8b6eMyfvYAJPMSjrf5KITuH%2BiumZs50WumUy9zv0%3D&reserved=0\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2Fservices%2Fcio-strategy-and-advisory-services%2F&hashtags=wiprodigital\n" +
        "https://www.linkedin.com/legal/sas-terms#additional-terms-for-optional-conversion-tracking\n" +
        "https://www.linkedin.com/in/sandhyararun\n" +
        "https://digistories.wiprodigital.com/?utm_source=Subscribe_Link&utm_medium=WD_Internal_clicks&utm_campaign=Digi%20Stories_%20Subscription_Internal_Clicks&utm_content=7010K000001eahI\n" +
        "https://www.linkedin.com/in/davidkenner/\n" +
        "https://www.linkedin.com/in/mnmurthy\n" +
        "https://support.google.com/chrome/answer/95647?co=GENIE.Platform=Desktop&hl=en\n" +
        "https://twitter.com/rahulshahtweets\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Ffeatures%2Fpresto%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690301733%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=oG30HMn1Ksliyit%2FEQSXC1uiPtw%2BL6rhqeqS8Gka1HA%3D&reserved=0\n" +
        "https://support.mozilla.org/en-US/kb/enable-and-disable-cookies-website-preferences\n" +
        "https://www.buzzsprout.com/636898/6552547\n" +
        "http://www.linkedin.com/shareArticle?mini=true&url=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&title=Gartner Names Wipro a Leader in Quality Engineering and Testing for Seventh Year&summary=https%3A%2F%2Fwiprodigital.com%2F2021%2F01%2F11%2Fgartner-names-wipro-a-leader-in-quality-engineering-and-testing-for-seventh-year%2F&source=wiprodigital.com\n" +
        "https://www.cloudbees.com/press/cloudbees-integrates-software-delivery-management-platform-google-cloud-build-and-tekton-break\n" +
        "https://designit.com\n" +
        "https://legal.twitter.com/ads-terms/us.html#twitteradsprogramt%26cs\n" +
        "https://www.linkedin.com/in/arun-melkote-88447a/?originalSubdomain=in\n" +
        "https://www.linkedin.com/in/karkera/\n" +
        "https://twitter.com/beal_a\n" +
        "https://apc01.safelinks.protection.outlook.com/?url=https%3A%2F%2Faws.amazon.com%2Femr%2Femr-migration%2F&data=04%7C01%7Ckirthi.belliyappa%40wipro.com%7C40911604fbde4227013a08d8c2981290%7C258ac4e4146a411e9dc879a9e12fd6da%7C1%7C0%7C637473305690321723%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C1000&sdata=jw%2B7XvjjMSNK05H0zbdp6uLKw%2F8SnPD76TZwy58HUUE%3D&reserved=0\n" +
        "http://twitter.com/share?text=Wipro Digital&url=https%3A%2F%2Fwiprodigital.com%2F2020%2F12%2F16%2Fpodcast-small-steps-to-become-a-better-agile-leader%2F&hashtags=wiprodigital\n" +
        "https://www.facebook.com/business/help/651294705016616?helpref=faq_content";
		try {
			String returnString = crawler.crawl("http://wiprodigital.com", 2);
			assertEquals(s, returnString);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
