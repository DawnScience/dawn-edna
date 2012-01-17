/*
 * Copyright (c) 2012 European Synchrotron Radiation Facility,
 *                    Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.dawb.passerelle.actors.edna;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/**
 * ISPyBStoreDataCollectionv1_3
 * 
 * @author svensson
 * @date October 6, 2011
 * @project org.dawb.passerelle.actors
 **/
public class ISPyBStoreDataCollectionv1_3 extends AbstractEdnaPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2056933313200018801L;
	/**
	 * 
	 */
	

	public ISPyBStoreDataCollectionv1_3(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginISPyBStoreDataCollectionv1_3", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputStoreDataCollection";
	}

	@Override
	protected String getSchemaLocation() {
		return "mxPluginExec/plugins/EDPluginGroupISPyB-v1.3/datamodel/XSDataISPyBv1_3.edml";
	}

	@Override
	protected String getPythonLocation() {
		return "mxPluginExec/plugins/EDPluginGroupISPyB-v1.3/plugins/EDPluginISPyBStoreDataCollectionv1_3.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "XSDataResultStoreDataCollection_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "ISPyB Store Data Collection";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputStoreDataCollection>\n");
		buf.append("${ispybDataCollection}\n");
		buf.append("</XSDataInputStoreDataCollection>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("dataCollectionId", "//dataCollectionId/value/text()");
	return props;
	}

}
