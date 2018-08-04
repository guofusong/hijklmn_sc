package edu.guosong.sc.hijklmnmediaserver.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.guosong.sc.hijklmnmediaserver.common.MediaUrlConfig;

@Configuration
public class MediaDirAdapter extends WebMvcConfigurerAdapter {

	private static final String WILDCARD = "**";

	@Autowired
	private MediaUrlConfig mediaUrlConfig;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(mediaUrlConfig.getImageRequestPath() + WILDCARD)
				.addResourceLocations(mediaUrlConfig.PREFIX + mediaUrlConfig.getImageLocalPath());
		registry.addResourceHandler(mediaUrlConfig.getSoundRequestPath() + WILDCARD)
				.addResourceLocations(mediaUrlConfig.PREFIX + mediaUrlConfig.getSoundLocalPath());
		registry.addResourceHandler(mediaUrlConfig.getVideoRequestPath() + WILDCARD)
				.addResourceLocations(mediaUrlConfig.PREFIX + mediaUrlConfig.getVideoLocalPath());
		super.addResourceHandlers(registry);
	}

}
