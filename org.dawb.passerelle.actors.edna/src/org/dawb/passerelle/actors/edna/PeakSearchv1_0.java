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
 * ControlCharForReorientationv2_0
 * 
 * @author svensson
 * @date April 6, 2011
 * @project org.edna.passerelle.actors
 **/
public class PeakSearchv1_0 extends AbstractEdnaPlugin {


	private static final long serialVersionUID = -2229884393788676874L;

	private final static Logger logger = LoggerFactory.getLogger(PeakSearchv1_0.class);

	public PeakSearchv1_0(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginExecPeakSearchv1_0", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputPeakSearch";
	}

	@Override
	protected String getSchemaLocation() {
		return "sandbox/id11/EDPluginExecPeakSearch-v1.0/datamodel/XSDataPeakSearchv1_0.xsd";
	}

	@Override
	protected String getPythonLocation() {
		return "sandbox/id11/EDPluginExecPeakSearch-v1.0/plugins/EDPluginExecPeakSearchv1_0.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "sandbox/id11/EDPluginExecPeakSearch-v1.0/tests/data/XSDataResultPeakSearch_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "Fable Peak Search";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputPeakSearch>\n");
		buf.append("  <stem><value>${file_dir}/ref-testscale_1_</value></stem>\n");
		buf.append("  <indexMin><value>1</value></indexMin>\n");
		buf.append("  <indexMax><value>1</value></indexMax>\n");
		buf.append("  <threshold><value>5</value></threshold>\n");
		buf.append("  <numberOfDigits><value>3</value></numberOfDigits>\n");
		buf.append("  <imageFormat><value>.img</value></imageFormat>\n");
		buf.append("</XSDataInputPeakSearch>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("peakFile2D", "//peakFile2D/path/value/text()");
		props.put("peakFile3D", "//peakFile3D/path/value/text()");
		return props;
	}

}
